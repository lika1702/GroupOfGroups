package course.groupofgroups;

import course.groupofgroups.model.UserProfile;
import course.groupofgroups.model.builder.UserProfileBuilderImpl;
import course.groupofgroups.repository.UserProfileRepository;
import course.groupofgroups.service.UserProfileService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestingClass {

    UserProfileRepository mock = Mockito.mock(UserProfileRepository.class);
    UserProfileService mockService = Mockito.mock(UserProfileService.class);

    @Test
    public void findingByEmail() {
        UserProfile user = new UserProfileBuilderImpl()
                .setEmail("snopok.lika@yandex.by")
                .build();
        when(mock.findByEmail("snopok.lika081@yandex.by")).thenReturn(user);

        UserProfile actualUser = new UserProfileBuilderImpl()
                .setEmail("snopok.lika@yandex.by")
                .build();
        assertEquals(user, actualUser);
    }

    @Test
    public void addingUser() {
        UserProfile user = new UserProfileBuilderImpl()
                .setEmail("snopok.lika@yandex.by")
                .build();
        when(mockService.add(user)).thenReturn(true);

        boolean actual = mockService.add(user);

        assertEquals(actual, true);
    }

}
