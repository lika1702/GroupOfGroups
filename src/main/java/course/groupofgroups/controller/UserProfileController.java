package course.groupofgroups.controller;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("object", new UserProfile());
        return "registration";
    }

    @GetMapping(value = "/profile")
    public String profilePage(Model model) {
        return "profile";
    }

    @PostMapping(value = "/registration")
    public String registration(UserProfile user, Model model) {
        if (!service.add(user)) {
            model.addAttribute("message", "Данный email уже зарегестрирован");
            return "redirect:/registration";
        }
        return "redirect:/login";
    }
}
