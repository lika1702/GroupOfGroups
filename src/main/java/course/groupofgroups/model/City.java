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
@Table(name = "City")
public class City extends CommonData {

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;
    
    @OneToMany(mappedBy = "hometown")
    private List<Profile> profiles;
}
