package course.groupofgroups.repository;

import course.groupofgroups.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    
}
