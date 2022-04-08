package course.groupofgroups.model;

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
@Table(name = "Education")
public class Education extends CommonData {

    @Column(name = "stage")
    private String level;

    @Column(name = "university")
    private String University;

    @Column(name = "year_of_graduation")
    private int yearOfGraduation;

    @ManyToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
