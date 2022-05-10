package course.groupofgroups.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Education")
public class Education extends CommonData {

    @Column(name = "stage")
    private String level;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @OneToMany(mappedBy = "education")
    private List<Profile> profile;
}
