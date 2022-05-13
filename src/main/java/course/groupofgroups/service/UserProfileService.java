package course.groupofgroups.service;

import course.groupofgroups.model.City;
import course.groupofgroups.model.Education;
import course.groupofgroups.model.Interest;
import course.groupofgroups.model.Language;
import course.groupofgroups.model.UserProfile;
import java.util.List;

public interface UserProfileService {

    public List<UserProfile> allUsers();
    
    public List<UserProfile> allUSER();
    
    public List<UserProfile> allADMIN();
    
    public List<UserProfile> allBLOCK();
    
    public List<UserProfile> allUNBLOCK();

    public List<City> findCities();

    public List<Language> findLanguages();

    public List<Interest> findInterests();

    public List<Education> findEducations();

    public UserProfile findById(Long id);

    public UserProfile findByEmail(String email);

    public boolean add(UserProfile user);

    public void edit(UserProfile user);

    public boolean delete(Long id);

    public boolean setBlock(UserProfile user);

    public String setRole(UserProfile user);
    
    public String setDesign(UserProfile user);
    
    public String setLocale(UserProfile user);
}
