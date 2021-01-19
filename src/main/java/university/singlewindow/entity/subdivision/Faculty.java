package university.singlewindow.entity.subdivision;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.singlewindow.entity.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "faculty")
public class Faculty extends TimedEntity {

    @Column(name = "title", nullable = false)
    private String title;

}
