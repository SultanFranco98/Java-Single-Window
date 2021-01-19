package university.singlewindow.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import university.singlewindow.entity.user.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
