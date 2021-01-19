package university.singlewindow.entity.subdivision;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.singlewindow.entity.base.TimedEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "specialty")
public class Specialty extends TimedEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
