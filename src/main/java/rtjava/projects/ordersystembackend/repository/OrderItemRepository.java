package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
