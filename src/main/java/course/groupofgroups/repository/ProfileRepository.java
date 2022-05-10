package course.groupofgroups.repository;

import course.groupofgroups.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    public Profile findByPhone(String phone);

    @Transactional
    @Modifying
    @Query("update Profile p set photo=?1 where id=?2")
    public void setPhotoById(String url, Long id);
}
