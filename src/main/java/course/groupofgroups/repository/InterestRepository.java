package course.groupofgroups.repository;

import course.groupofgroups.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, Long> {

    public Interest findByName(String name);
}
