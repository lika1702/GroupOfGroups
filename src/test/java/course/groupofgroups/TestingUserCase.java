package course.groupofgroups;

import course.groupofgroups.model.Profile;
import course.groupofgroups.model.UserProfile;
import course.groupofgroups.model.builder.UserProfileBuilderImpl;
import course.groupofgroups.repository.ProfileRepository;
import course.groupofgroups.repository.UserProfileRepository;
import course.groupofgroups.service.Implementation.ProfileServiceImpl;
import course.groupofgroups.service.Implementation.UserProfileServiceImpl;
import course.groupofgroups.service.UserProfileService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestingUserCase {

    @Autowired
    UserProfileRepository repository;

    @Autowired
    ProfileRepository profileRepository;

    UserProfileService service;

    @BeforeEach
    void setup() {
        repository.save(new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setDesign("light")
                .setLocale("deutch")
                .setRole("USER")
                .setBlock(false)
                .build());
        repository.save(new UserProfileBuilderImpl()
                .setId(2L)
                .setEmail("email@yandex.by")
                .setDesign("dark")
                .setLocale("russian")
                .setRole("ADMIN")
                .setBlock(true)
                .build());

        this.service = new UserProfileServiceImpl(repository,
                new ProfileServiceImpl(profileRepository),
                new BCryptPasswordEncoder(10)
        );
    }

    @Test
    public void findingByEmail() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setDesign("light")
                .setLocale("deutch")
                .setRole("USER")
                .setBlock(false)
                .build();

        UserProfile actual = service.findByEmail("snopok.lika@yandex.by");
        assertEquals(user, actual);
    }

    @Test
    public void testFindAll() {
        List<UserProfile> expacted = new ArrayList<>();
        expacted.add(new UserProfile());
        expacted.add(new UserProfile());

        int count = service.allUsers().size();
        assertEquals(expacted.size(), count);
    }

    @Test
    public void testAddUser() {
        UserProfile user = new UserProfileBuilderImpl()
                .setEmail("snopok.lika@yandex.by")
                .setPassword("123")
                .setProfile(new Profile())
                .build();

        boolean actual = service.add(user);

        assertEquals(false, actual);
    }

    @Test
    public void testAddUserFailed() {
        UserProfile user = new UserProfileBuilderImpl()
                .setEmail("another.email@yandex.by")
                .setPassword("123")
                .setProfile(new Profile())
                .build();

        boolean actual = service.add(user);

        assertEquals(true, actual);
    }

    @Test
    public void testChangeDesignOnDark() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setDesign("dark")
                .build();

        String actual = service.setDesign(user);

        assertEquals("light", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeDesignOnLight() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(2L)
                .setEmail("email@yandex.by")
                .setDesign("light")
                .build();

        String actual = service.setDesign(user);

        assertEquals("dark", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeRoleOnADMIN() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setRole("ADMIN")
                .build();

        String actual = service.setRole(user);

        assertEquals("USER", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeRoleOnUSER() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(2L)
                .setEmail("email@yandex.by")
                .setRole("USER")
                .build();

        String actual = service.setRole(user);

        assertEquals("ADMIN", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeBlokOnTrue() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setBlock(true)
                .build();

        boolean actual = service.setBlock(user);

        assertEquals(false, actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeBlokOnFalse() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(2L)
                .setEmail("email@yandex.by")
                .setBlock(false)
                .build();

        boolean actual = service.setBlock(user);

        assertEquals(true, actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeLanguageOnEnglish() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setLocale("english")
                .build();

        String actual = service.setLocale(user);

        assertEquals("deutch", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeLanguageOnDeutch() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(2L)
                .setEmail("email@yandex.by")
                .setLocale("deutch")
                .build();

        String actual = service.setLocale(user);

        assertEquals("russian", actual, "Test failed: values do not match");
    }

    @Test
    public void testChangeLanguageOnRussian() {
        UserProfile user = new UserProfileBuilderImpl()
                .setId(1L)
                .setEmail("snopok.lika@yandex.by")
                .setLocale("russian")
                .build();

        String actual = service.setLocale(user);

        assertEquals("deutch", actual, "Test failed: values do not match");
    }

    @Test
    public void testFilterByUSER() {
        List<UserProfile> actual = service.allUSER();

        assertEquals(1, actual.size());
    }

    @Test
    public void testFilterByADMIN() {
        List<UserProfile> actual = service.allADMIN();

        assertEquals(1, actual.size());
    }

    @Test
    public void testFilterByBLOCK() {
        List<UserProfile> actual = service.allBLOCK();

        assertEquals(1, actual.size());
    }

    @Test
    public void testFilterByUNBLOCK() {
        List<UserProfile> actual = service.allUNBLOCK();

        assertEquals(1, actual.size());
    }
}
