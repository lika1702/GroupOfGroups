package course.groupofgroups.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Dialog")
public class Dialog extends CommonData {

    @Column(name = "name")
    private String name;

    @Column(name = "art")
    private String art;

    @ManyToOne
    @JoinColumn(name = "social_network_id")
    private SocialNetwork socialNetwork;

    @ManyToMany(mappedBy = "dialogs")
    private List<UserProfile> users;

    @OneToMany(mappedBy = "dialog")
    private List<Message> messages;
}
