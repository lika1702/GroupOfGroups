package course.groupofgroups.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class UserProfile extends CommonData {

    @Column(name = "surname")
    private String surname;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="date_of_registration")
    private Date dateOfRegistration;
    
    @Column(name="last_login")
    private Date lastLogin;
    
    @Column(name="block")
    private Boolean block;
    
    @Column(name="status")
    private String status;
    
    @Column(name="design")
    private String design;
    
    @Column(name="language")
    private String language;
}
