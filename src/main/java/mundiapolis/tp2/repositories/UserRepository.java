package mundiapolis.tp2.repositories;

import mundiapolis.tp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String userName);
}
