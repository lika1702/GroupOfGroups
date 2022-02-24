package course.groupofgroups.service;

import course.groupofgroups.model.UserProfile;
import java.util.List;

public interface UserProfileService {

    public List<UserProfile> allUsers();

    public UserProfile findById(Long id);
}
