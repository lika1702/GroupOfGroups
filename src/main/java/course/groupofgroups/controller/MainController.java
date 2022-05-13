package course.groupofgroups.controller;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserProfileService service;

    @GetMapping(value = "/")
    public String homePage(Model model) {
        try {
            UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(userInfo);
            UserProfile user = service.findByEmail(userInfo.getUsername());
            model.addAttribute("design", user.getDesign());
            return "index";
        } catch (Exception ex) {
            return "index";
        }
    }

    @GetMapping(value = "/chat")
    public String chatPage(Model model) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile user = service.findByEmail(userInfo.getUsername());
        model.addAttribute("existUser", user);
        return "chat";
    }

    @GetMapping(value = "/403")
    public String accessDeniedPage() {
        return "error/403";
    }
}
