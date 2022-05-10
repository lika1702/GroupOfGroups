package course.groupofgroups.model.builder;

import course.groupofgroups.model.Dialog;
import course.groupofgroups.model.Message;
import course.groupofgroups.model.Profile;
import course.groupofgroups.model.UserProfile;
import java.util.Date;
import java.util.List;

public interface UserProfileBuilder {

    public UserProfileBuilder setEmail(String email);

    public UserProfileBuilder setPassword(String password);

    public UserProfileBuilder setDateOfRegistration(Date dateOfRegistration);

    public UserProfileBuilder setLastLogin(Date lastLogin);

    public UserProfileBuilder setBlock(Boolean block);

    public UserProfileBuilder setRole(String role);

    public UserProfileBuilder setDesign(String design);

    public UserProfileBuilder setLocale(String locale);

    public UserProfileBuilder setProfile(Profile profile);

    public UserProfileBuilder setDialogs(List<Dialog> dialogs);

    public UserProfileBuilder setMessages(List<Message> messages);

    public UserProfile build();
}
