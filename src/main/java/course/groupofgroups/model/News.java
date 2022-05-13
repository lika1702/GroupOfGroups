package course.groupofgroups.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "News")
public class News extends CommonData {

    @Column(name = "header")
    private String header;

    @Column(name = "topic")
    private String topic;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "author")
    private UserProfile author;

    public News() {
    }

    public News(String header) {
        this.header = header;
    }

    public News(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public News(String header, String topic, String text, Date date, UserProfile author, Long id) {
        super(id);
        this.header = header;
        this.topic = topic;
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public News(Long id, String header) {
        super(id);
        this.header = header;
    }

    private static Long total = 0L;

    public static Long getTotalCount() {
        return total;
    }

    public static void setTotalCount(Long count) {
        total = count;
    }

    public static void addTotalCount() {
        total++;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.header);
        hash = 97 * hash + Objects.hashCode(this.topic);
        hash = 97 * hash + Objects.hashCode(this.text);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.author);
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
        final News other = (News) obj;
        if (!Objects.equals(this.header, other.header)) {
            return false;
        }
        if (!Objects.equals(this.topic, other.topic)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }
    
    
}
