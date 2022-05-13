package course.groupofgroups.model.builder;

import course.groupofgroups.model.Dialog;
import course.groupofgroups.model.Message;
import course.groupofgroups.model.Profile;
import course.groupofgroups.model.UserProfile;
import java.util.Date;
import java.util.List;

public class UserProfileBuilderImpl implements UserProfileBuilder {

    private Long id;
    private String email;
    private String password;
    private Date dateOfRegistration;
    private Date lastLogin;
    private Boolean block;
    private String role;
    private String design;
    private String locale;
    private Profile profile;
    private List<Dialog> dialogs;
    private List<Message> messages;

    @Override
    public UserProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserProfileBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserProfileBuilder setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    @Override
    public UserProfileBuilder setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    @Override
    public UserProfileBuilder setBlock(Boolean block) {
        this.block = block;
        return this;
    }

    @Override
    public UserProfileBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public UserProfileBuilder setDesign(String design) {
        this.design = design;
        return this;
    }

    @Override
    public UserProfileBuilder setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    @Override
    public UserProfileBuilder setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    @Override
    public UserProfileBuilder setDialogs(List<Dialog> dialogs) {
        this.dialogs = dialogs;
        return this;
    }

    @Override
    public UserProfileBuilder setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    @Override
    public UserProfileBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserProfile build() {
        return new UserProfile(id, email, password, dateOfRegistration, lastLogin, block, role, design, locale, profile, dialogs, messages);
    }

}
