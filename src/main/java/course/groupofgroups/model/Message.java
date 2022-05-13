package course.groupofgroups.model;

import java.util.Date;
import java.util.Objects;
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

    public Message() {
    }

    public Message(Long id, String text) {
        super(id);
        this.text = text;
    }

    public Message(String text, Date date, Dialog dialog, UserProfile user, Long id) {
        super(id);
        this.text = text;
        this.date = date;
        this.dialog = dialog;
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.text);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.dialog);
        hash = 67 * hash + Objects.hashCode(this.user);
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
        final Message other = (Message) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.dialog, other.dialog)) {
            return false;
        }
        return Objects.equals(this.user, other.user);
    }

}
