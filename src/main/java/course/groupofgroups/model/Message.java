package course.groupofgroups.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Message")
public class Message extends CommonData {

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "dialog_id")
    private Dialog dialog;

    @ManyToOne
    @JoinColumn(name = "sender")
    private UserProfile user;

}
