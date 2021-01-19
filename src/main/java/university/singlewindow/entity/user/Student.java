package university.singlewindow.entity.user;

import university.singlewindow.entity.base.TimedEntity;
import university.singlewindow.entity.subdivision.Group;
import university.singlewindow.enums.GenderName;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student extends TimedEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "dot", nullable = false)
    private LocalDate dot;

    @Column(name = "sex", nullable = false)
    private GenderName gender;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
