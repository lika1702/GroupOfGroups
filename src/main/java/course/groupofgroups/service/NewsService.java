package course.groupofgroups.service;

import course.groupofgroups.model.News;
import java.util.List;

public interface NewsService {

    public List<News> allNews();

    public News findById(Long id);

    public boolean add(News news);

    public boolean delete(Long id);

}
