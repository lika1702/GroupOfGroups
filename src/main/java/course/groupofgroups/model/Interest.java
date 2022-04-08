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
@Table(name = "Interest")
public class Interest extends CommonData {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "interests")
    private List<Profile> profiles;
}
