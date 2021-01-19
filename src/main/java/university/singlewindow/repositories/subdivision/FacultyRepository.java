package university.singlewindow.repositories.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.singlewindow.entity.subdivision.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
