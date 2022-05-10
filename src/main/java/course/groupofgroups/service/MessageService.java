package course.groupofgroups.service;

import course.groupofgroups.model.Message;

public interface MessageService {

    public Message findById(Long id);

    public void add(Message message);
}
