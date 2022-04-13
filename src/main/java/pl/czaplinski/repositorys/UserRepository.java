package pl.czaplinski.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.czaplinski.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
