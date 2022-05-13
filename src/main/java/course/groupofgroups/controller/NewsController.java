package course.groupofgroups.controller;

import course.groupofgroups.model.News;
import course.groupofgroups.model.UserProfile;
import course.groupofgroups.service.NewsService;
import course.groupofgroups.service.UserProfileService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService service;

    @GetMapping(value = "/all")
    public String newsPage(Model model) {
        List<News> news = service.allNews();
        if (!news.isEmpty()) {
            model.addAttribute("news", news);
            model.addAttribute("total", News.getTotalCount());
        }
        model.addAttribute("newNew", new News());
        return "news";
    }

    @PostMapping(value = "/offer")
    public String offerNews(News newNew) {
        service.add(newNew);
        return "redirect:/news/all";
    }
}
