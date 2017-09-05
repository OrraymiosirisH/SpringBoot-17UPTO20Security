package guevara.demo.repository;

import guevara.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {


}