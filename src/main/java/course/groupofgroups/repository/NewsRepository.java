package course.groupofgroups.repository;

import course.groupofgroups.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

    public News findByHeader(String header);
}
