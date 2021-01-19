package university.singlewindow.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import university.singlewindow.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
