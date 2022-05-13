package course.groupofgroups;

import course.groupofgroups.model.News;
import course.groupofgroups.repository.NewsRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestingNewsCase {

    @Autowired
    NewsRepository repository;

    @BeforeEach
    void setup() {
        repository.save(new News(1L, "header 1"));
        repository.save(new News(2L, "header 2"));
    }

    @Test
    public void testFindAll() {
        List<News> all = repository.findAll();

        assertEquals(2, all.size(), "The sizes is different");
    }

    @Test
    public void testFindById() {
        News actual = new News(1L, "header 1");
        News news = repository.findByHeader("header 1");

        assertNotNull(news);
        assertEquals(actual, news, "Results don't match");
    }

    @Test
    public void testAddNews() {
        News obj = new News(5L, "New");
        boolean result;
        if (repository.findByHeader("New") != null) {
            result = false;
        } else {
            repository.save(obj);
            result = true;
        }

        assertEquals(true, result, "Object already exist");
    }

    @Test
    public void testAddNewsFailed() {
        News obj = new News(1L, "header");
        boolean result;
        if (repository.findByHeader("header 1") != null) {
            result = false;
        } else {
            repository.save(obj);
            result = true;
        }

        assertEquals(false, result, "Object already exist");
    }
}
