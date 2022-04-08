package course.groupofgroups.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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

    @Transient
    private String confirmPassword;

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
            joinColumns = @JoinColumn(name = "pfofile_id"),
            inverseJoinColumns = @JoinColumn(name = "dialog_id"))
    private List<Dialog> dialogs;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;
}
