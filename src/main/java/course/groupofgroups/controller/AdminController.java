package course.groupofgroups.controller;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.UserProfileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserProfileService service;

    @GetMapping(value = "/")
    public String adminPage(Model model, @RequestParam(name = "filt", required = false) String filter) {
        List<UserProfile> all = service.allUsers();
        List<UserProfile> filt = new ArrayList<>();
        if (filter == null) {
            model.addAttribute("users", all);
            return "admin";
        }
        switch (filter) {
            case "block":
                filt = service.allBLOCK();
                break;
            case "unblock":
                filt = service.allUNBLOCK();
                break;
            case "admin":
                filt = service.allADMIN();
                break;
            case "user":
                filt = service.allUSER();
                break;
        }
        model.addAttribute("users", filt);
        return "admin";
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/admin/";
    }

    @PostMapping(value = "/users/save")
    public String saveUser(UserProfile user) {
        service.setBlock(user);
        service.setRole(user);
        return "redirect:/admin/";
    }

}
