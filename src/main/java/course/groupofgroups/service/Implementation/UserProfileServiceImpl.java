package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.City;
import course.groupofgroups.model.Education;
import course.groupofgroups.model.Interest;
import course.groupofgroups.model.Language;
import course.groupofgroups.model.UserProfile;
import course.groupofgroups.repository.UserProfileRepository;
import course.groupofgroups.service.CityService;
import course.groupofgroups.service.EducationService;
import course.groupofgroups.service.InterestService;
import course.groupofgroups.service.LanguageService;
import course.groupofgroups.service.ProfileService;
import course.groupofgroups.service.UserProfileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private InterestService interestService;

    @Autowired
    private EducationService educationService;

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
        long profileId = profileService.add(user.getProfile());
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setProfile(profileService.findById(profileId));
        repository.save(user);
        return true;
    }

    @Override
    public UserProfile findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<City> findCities() {
        return cityService.allCities();
    }

    @Override
    public List<Language> findLanguages() {
        return languageService.allLanguages();
    }

    @Override
    public List<Interest> findInterests() {
        return interestService.allInterests();
    }

    @Override
    public List<Education> findEducations() {
        return educationService.allEducations();
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public void edit(UserProfile user) {
        UserProfile existUser = repository.findById(user.getId()).get();
        user.getProfile().setId(existUser.getProfile().getId());
        profileService.edit(user.getProfile());
    }

    @Override
    public boolean setBlock(UserProfile user) {
        repository.setBlockById(user.getBlock(), user.getId());
        return !user.getBlock();
    }

    @Override
    public String setRole(UserProfile user) {
        repository.setRoleById(user.getRole(), user.getId());
        if (user.getRole().equals("ADMIN")) {
            return "USER";
        } else {
            return "ADMIN";
        }
    }

    @Override
    public String setDesign(UserProfile user) {
        repository.setDesignById(user.getDesign(), user.getId());
        if (user.getDesign().equals("light")) {
            return "dark";
        } else {
            return "light";
        }
    }

    @Override
    public String setLocale(UserProfile user) {
        UserProfile exist = repository.findByEmail(user.getEmail());
        repository.setLocaleById(user.getLocale(), user.getId());
        return exist.getLocale();
    }

    public UserProfileServiceImpl() {
    }

    public UserProfileServiceImpl(UserProfileRepository repository, ProfileService profileService, BCryptPasswordEncoder bCrypt) {
        this.repository = repository;
        this.profileService = profileService;
        this.bCrypt = bCrypt;
    }

    @Override
    public List<UserProfile> allUSER() {
        List<UserProfile> all = repository.findAll();
        List<UserProfile> filt = new ArrayList<>();
        for (UserProfile u : all) {
            if (u.getRole().equals("ADMIN")) {
                filt.add(u);
            }
        }
        return filt;
    }

    @Override
    public List<UserProfile> allADMIN() {
        List<UserProfile> all = repository.findAll();
        List<UserProfile> filt = new ArrayList<>();
        for (UserProfile u : all) {
            if (u.getRole().equals("USER")) {
                filt.add(u);
            }
        }
        return filt;
    }

    @Override
    public List<UserProfile> allBLOCK() {
        List<UserProfile> all = repository.findAll();
        List<UserProfile> filt = new ArrayList<>();
        for (UserProfile u : all) {
            if (u.getBlock()) {
                filt.add(u);
            }
        }
        return filt;
    }

    @Override
    public List<UserProfile> allUNBLOCK() {
        List<UserProfile> all = repository.findAll();
        List<UserProfile> filt = new ArrayList<>();
        for (UserProfile u : all) {
            if (!u.getBlock()) {
                filt.add(u);
            }
        }
        return filt;
    }

}
