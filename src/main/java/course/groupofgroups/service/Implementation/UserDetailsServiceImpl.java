package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.repository.UserProfileRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserProfileRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = repository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user: " + username);
        }
        repository.setLastLoginById(new Date(), user.getId());
        UserDetails userDetails = User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
        return userDetails;
    }

}
