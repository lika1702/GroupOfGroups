package course.groupofgroups.repository;

import course.groupofgroups.model.UserProfile;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    public UserProfile findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update UserProfile u set u.lastLogin=?1 where u.id=?2")
    void setLastLoginById(Date lastLogin, Long id);
}
