package university.singlewindow.repositories.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import university.singlewindow.entity.subdivision.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
