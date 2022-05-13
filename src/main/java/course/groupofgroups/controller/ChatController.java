package course.groupofgroups.controller;

import course.groupofgroups.model.Dialog;
import course.groupofgroups.model.Message;
import course.groupofgroups.model.Profile;
import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.DialogService;
import course.groupofgroups.service.MessageService;
import course.groupofgroups.service.SocialNetworkService;
import course.groupofgroups.service.UserProfileService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Achievement;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Group;
import org.springframework.social.facebook.api.GroupMembership;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    @Autowired
    private UserProfileService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SocialNetworkService socialService;

    @Autowired
    private DialogService service;

    private FacebookConnectionFactory factory = new FacebookConnectionFactory("730051138122994",
            "20e86d48698d513491d95bead1949766");

    @GetMapping(value = "/facebook/groups")
    public String producer() {

        OAuth2Operations operations = factory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8080/forwardLogin");
        params.setScope("email,public_profile");
        String url = operations.buildAuthenticateUrl(params);
        System.out.println("The URL is" + url);
        return "redirect:" + url;

    }

    @RequestMapping(value = "/forwardLogin")
    public String prodducer(@RequestParam("code") String authorizationCode, Model model) {
        OAuth2Operations operations = factory.getOAuthOperations();
        AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8080/forwardLogin",
                null);

        Connection<Facebook> connection = factory.createConnection(accessToken);
        Facebook facebook = connection.getApi();

        String[] fields = {"email"};
        UserProfile userProfile = facebook.fetchObject("me", UserProfile.class, fields);
        System.out.println(userProfile.getEmail());

        String[] name = facebook.fetchObject("me", Profile.class, "name").getName().split(" ");

        userProfile.setProfile(new Profile());
        userProfile.getProfile().setSurname(name[1]);
        userProfile.getProfile().setName(name[0]);
        model.addAttribute("user", userProfile);
        return "profile";

    }

    @RequestMapping(value = "/profile/me")
    public String facebookData(@RequestParam("code") String authorizationCode, Model model) {
        OAuth2Operations operations = factory.getOAuthOperations();
        AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8080/profile/me", null);

        Connection<Facebook> connection = factory.createConnection(accessToken);
        Facebook facebook = connection.getApi();

        List<Group> groups = facebook.fetchConnections("me", "groups", Group.class);
        System.out.println(groups);

        List<GroupMembership> listGroup = facebook.groupOperations().getMemberships();
        System.out.println(listGroup);

        System.out.println(facebook.toString());

        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile user = userService.findByEmail(userInfo.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("posts", groups);
        return "profile";
    }

    @GetMapping(value = "/chat/add/{email}")
    public String addChat(@PathVariable(name = "email") String email, Model model) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile sender = userService.findByEmail(userInfo.getUsername());
        UserProfile reciever = userService.findByEmail(email);
        List<UserProfile> users = new ArrayList<>();
        users.add(sender);
        users.add(reciever);
        Dialog newDialog = new Dialog();
        newDialog.setName(sender.getProfile().getSurname() + ' ' + sender.getProfile().getName() + '-' + reciever.getProfile().getSurname() + ' ' + reciever.getProfile().getName());
        newDialog.setArt(reciever.getProfile().getPhoto());
        newDialog.setUsers(users);
        sender.addDialog(newDialog);
        reciever.addDialog(newDialog);
        userService.add(sender);
        userService.add(reciever);
        service.add(newDialog);
        return "redirect:/chat";
    }

    @GetMapping(value = "/chat/with/{id}")
    public String chatWith(@PathVariable(name = "id") Long id, Model model) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile me = userService.findByEmail(userInfo.getUsername());
        UserProfile reciever = userService.findById(id);
        for (Dialog dialog : me.getDialogs()) {
            for (UserProfile u : dialog.getUsers()) {
                if (u.getId().longValue() == id) {
                    model.addAttribute("openDialog", dialog);
                }
            }
        }
        model.addAttribute("newMesssage", new Message());
        model.addAttribute("existUser", me);
        return "chat";
    }

    @PostMapping(value = "sent/{id}")
    public String sentMessage(@PathVariable(name = "id") Long id, Message newMessage) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile me = userService.findByEmail(userInfo.getUsername());
        Dialog dialog = service.findById(id);
        newMessage.setUser(me);
        newMessage.setDate(new Date());
        newMessage.setDialog(dialog);
        messageService.add(newMessage);
        Long idS = 0L;
        for (UserProfile u : dialog.getUsers()) {
            if (u.getId().longValue() != me.getId().longValue()) {
                idS = u.getId();
            }
        }
        return "redirect:/chat/with/" + idS;
    }

}
