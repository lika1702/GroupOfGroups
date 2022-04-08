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
@Table(name = "Social_network")
public class SocialNetwork extends CommonData {

    @Column(name = "name")
    private String name;

    @Column(name = "icon")
    private String icon;
    
    @OneToMany(mappedBy="socialNetwork")
    private List<Dialog> dialogs;
}
