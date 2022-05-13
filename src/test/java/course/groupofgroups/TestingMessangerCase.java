package course.groupofgroups;

import course.groupofgroups.model.Message;
import course.groupofgroups.repository.MessageRepository;
import course.groupofgroups.service.Implementation.MessageServiceImpl;
import course.groupofgroups.service.MessageService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestingMessangerCase {

    @Autowired
    MessageRepository repository;

    MessageService service;

    @BeforeEach
    void setup() {
        repository.save(new Message(1L, "message text 1"));
        repository.save(new Message(2L, "message text 2"));

        this.service = new MessageServiceImpl(repository);
    }

    @Test
    public void testFindAll() {
        List<Message> expacted = new ArrayList<>();
        expacted.add(new Message(1L, "message text 1"));
        expacted.add(new Message(2L, "message text 2"));

        assertEquals(expacted, service.allMessages());
    }

    @Test
    public void testAddMessage() {
        Message obj = new Message(5L, "Message");

        boolean result = service.add(obj);

        assertEquals(true, result, "Object already exist");
    }

}
