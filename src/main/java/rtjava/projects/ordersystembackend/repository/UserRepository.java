package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
