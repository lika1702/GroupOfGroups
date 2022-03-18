package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.repository.UserProfileRepository;
import course.groupofgroups.service.UserProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Override
    public List<UserProfile> allUsers() {
        return repository.findAll();
    }

    @Override
    public UserProfile findById(Long id) {
        return repository.getById(id);
    }

    @Override
    public boolean add(UserProfile user) {
        if (repository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        user.setPassword(bCrypt.encode(user.getPassword()));
        repository.save(user);
        return true;
    }
}
