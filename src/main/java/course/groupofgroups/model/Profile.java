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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Profile")
public class Profile extends CommonData {

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "photo")
    private String photo;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "autobiography")
    private String autobiography;

    @OneToMany(mappedBy = "profile")
    private List<Education> educations;

    @ManyToOne
    @JoinColumn(name = "hometown")
    private City hometown;

    @ManyToMany
    @JoinTable(name = "profile_language",
            joinColumns = @JoinColumn(name = "pfofile_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @ManyToMany
    @JoinTable(name = "profile_interest",
            joinColumns = @JoinColumn(name = "pfofile_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id"))
    private List<Interest> interests;

    @OneToMany(mappedBy = "profile")
    private List<UserProfile> account;

}
