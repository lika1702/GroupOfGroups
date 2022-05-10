package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Message;
import course.groupofgroups.repository.MessageRepository;
import course.groupofgroups.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public Message findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void add(Message message) {
        repository.save(message);
    }

}
