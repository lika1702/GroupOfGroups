package course.groupofgroups.controller;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.UserProfileService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new UserProfile());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(UserProfile user) {
        if (!service.add(user)) {
            return "redirect:/registration?message";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/users")
    public String usersPage(Model model) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile user = service.findByEmail(userInfo.getUsername());
        model.addAttribute("design", user.getDesign());
        model.addAttribute("users", service.allUsers());
        model.addAttribute("exist", user);
        return "users";
    }

    @GetMapping(value = "/profile/{email}")
    public String profilePage(@PathVariable(name = "email") String email, Model model) throws Exception {
        UserProfile user = service.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping(value = "/settings")
    public String editPage(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("user", service.findById(id));
        model.addAttribute("cities", service.findCities());
        model.addAttribute("languages", service.findLanguages());
        model.addAttribute("interests", service.findInterests());
        model.addAttribute("universities", service.findEducations());
        return "edit_profile";
    }

    @PostMapping(value = "/settings/confirm")
    public String edit(UserProfile user, Model model) {
        System.out.println(user.getProfile().getLanguages());
        service.edit(user);
        return "redirect:/profile/" + user.getEmail();
    }

    @GetMapping("/design/change")
    public String designChange(HttpServletRequest request) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile user = service.findByEmail(userInfo.getUsername());
        switch (user.getDesign()) {
            case "light":
                user.setDesign("dark");
                break;
            case "dark":
                user.setDesign("light");
                break;
        }
        service.edit(user);
        return "redirect:" + request.getHeader("referer");
    }
}
