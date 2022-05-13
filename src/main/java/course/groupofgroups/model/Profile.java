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
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "autobiography")
    private String autobiography;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "hometown")
    private City hometown;

    @ManyToMany
    @JoinTable(name = "profile_language",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @ManyToMany
    @JoinTable(name = "profile_interest",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id"))
    private List<Interest> interests;

    @OneToMany(mappedBy = "profile")
    private List<UserProfile> account;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.photo);
        hash = 97 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.autobiography);
        hash = 97 * hash + Objects.hashCode(this.education);
        hash = 97 * hash + Objects.hashCode(this.hometown);
        hash = 97 * hash + Objects.hashCode(this.languages);
        hash = 97 * hash + Objects.hashCode(this.interests);
        hash = 97 * hash + Objects.hashCode(this.account);
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
        final Profile other = (Profile) obj;
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.autobiography, other.autobiography)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.education, other.education)) {
            return false;
        }
        if (!Objects.equals(this.hometown, other.hometown)) {
            return false;
        }
        if (!Objects.equals(this.languages, other.languages)) {
            return false;
        }
        if (!Objects.equals(this.interests, other.interests)) {
            return false;
        }
        return Objects.equals(this.account, other.account);
    }

    
    
}
