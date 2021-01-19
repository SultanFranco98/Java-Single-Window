package university.singlewindow.repositories.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.singlewindow.entity.subdivision.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
