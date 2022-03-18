package course.groupofgroups.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "language")
    private String language = "russian";
}
