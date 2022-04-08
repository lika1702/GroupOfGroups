package course.groupofgroups.repository;

import course.groupofgroups.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
