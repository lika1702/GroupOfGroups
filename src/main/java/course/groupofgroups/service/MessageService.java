package course.groupofgroups.service;

import course.groupofgroups.model.Message;
import java.util.List;

public interface MessageService {
    
    public List<Message> allMessages();

    public Message findById(Long id);

    public boolean add(Message message);
}
