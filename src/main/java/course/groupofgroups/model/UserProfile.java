package course.groupofgroups.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class UserProfile extends CommonData {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration = new Date();

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "block")
    private Boolean block = false;

    @Column(name = "role")
    private String role = "USER";

    @Column(name = "design")
    private String design = "light";

    @Column(name = "locale")
    private String locale = "russian";

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany
    @JoinTable(name = "profile_dialog",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "dialog_id"))
    private List<Dialog> dialogs;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;

    public UserProfile() {
    }

    public UserProfile(String email, String password, Date dateOfRegistration,
            Date lastLogin, Boolean block, String role, String design,
            String locale, Profile profile, List<Dialog> dialogs, List<Message> messages) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.dateOfRegistration = dateOfRegistration;
        this.lastLogin = lastLogin;
        this.block = block;
        this.design = design;
        this.role = role;
        this.locale = locale;
        this.dialogs = dialogs;
        this.messages = messages;
    }

    public void addDialog(Dialog dialog) {
        this.dialogs.add(dialog);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserProfile other = (UserProfile) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.design, other.design)) {
            return false;
        }
        if (!Objects.equals(this.locale, other.locale)) {
            return false;
        }
        if (!Objects.equals(this.dateOfRegistration, other.dateOfRegistration)) {
            return false;
        }
        if (!Objects.equals(this.lastLogin, other.lastLogin)) {
            return false;
        }
        if (!Objects.equals(this.block, other.block)) {
            return false;
        }
        if (!Objects.equals(this.profile, other.profile)) {
            return false;
        }
        if (!Objects.equals(this.dialogs, other.dialogs)) {
            return false;
        }
        return Objects.equals(this.messages, other.messages);
    }

}
