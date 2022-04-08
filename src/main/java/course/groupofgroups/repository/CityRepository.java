package course.groupofgroups.repository;

import course.groupofgroups.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
