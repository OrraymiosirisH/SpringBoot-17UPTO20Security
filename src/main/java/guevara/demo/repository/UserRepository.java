package guevara.demo.repository;

import guevara.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

User findByUsername(String username);

}
