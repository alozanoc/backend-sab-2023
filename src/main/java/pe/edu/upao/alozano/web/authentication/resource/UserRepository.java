package pe.edu.upao.alozano.web.authentication.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upao.alozano.web.authentication.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = :username")
    Optional<User> findByUsername(String username);
}
