package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // e.g., custom queries if needed
    // List<Order> findByOrderId(Long orderId);
    // List<Order> findByUserId(Long userId);
}
