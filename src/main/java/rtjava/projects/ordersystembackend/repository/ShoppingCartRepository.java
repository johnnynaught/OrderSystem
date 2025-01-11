package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    // e.g., custom queries if needed
    // List<ShoppingCart> findByUserId(Long userId);
    // List<ShoppingCart> findByCartId(Long cartId);
}
