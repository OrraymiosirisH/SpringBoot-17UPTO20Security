package guevara.demo.repository;


import guevara.demo.model.Role;
import org.springframework.data.repository.CrudRepository;



public interface RoleRepository extends CrudRepository<Role, Long> {

    Iterable<Role>findAllById(Long Long);
    Iterable<Role>findRoleByRole(String String);
    Role findByRole(String role);
}