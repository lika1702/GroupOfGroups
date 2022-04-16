package course.groupofgroups.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String homePage(Model model) {
        return "index";
    }
    
    @GetMapping(value = "/chat")
    public String chatPage(Model model) {
        return "chat";
    }
}
