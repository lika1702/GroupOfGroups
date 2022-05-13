package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.News;
import course.groupofgroups.model.UserProfile;
import course.groupofgroups.repository.NewsRepository;
import course.groupofgroups.service.NewsService;
import course.groupofgroups.service.UserProfileService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository repository;

    @Autowired
    private UserProfileService userService;

    @Override
    public List<News> allNews() {
        return repository.findAll();
    }

    @Override
    public News findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean add(News news) {
        UserDetails userInfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserProfile user = userService.findByEmail(userInfo.getUsername());
        news.setAuthor(user);
        news.setDate(new Date());
        repository.save(news);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

}
