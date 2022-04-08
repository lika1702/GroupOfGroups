package course.groupofgroups.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Language")
public class Language extends CommonData {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "languages")
    private List<Profile> profiles;
}
