package course.groupofgroups.service;

import course.groupofgroups.model.City;
import course.groupofgroups.model.Education;
import course.groupofgroups.model.Interest;
import course.groupofgroups.model.Language;
import course.groupofgroups.model.UserProfile;
import java.util.List;

public interface UserProfileService {

    public List<UserProfile> allUsers();

    public List<City> findCities();

    public List<Language> findLanguages();

    public List<Interest> findInterests();

    public List<Education> findEducations();

    public UserProfile findById(Long id);

    public UserProfile findByEmail(String email);

    public boolean add(UserProfile user);

    public void edit(UserProfile user);

    public void delete(Long id);

    public void setBlock(UserProfile user);

    public void setRole(UserProfile user);
}
