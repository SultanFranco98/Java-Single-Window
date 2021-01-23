package university.singlewindow.entity.subdivision;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import university.singlewindow.entity.base.TimedEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
