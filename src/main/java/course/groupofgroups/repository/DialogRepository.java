package course.groupofgroups.repository;

import course.groupofgroups.model.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DialogRepository extends JpaRepository<Dialog, Long> {
    
}
