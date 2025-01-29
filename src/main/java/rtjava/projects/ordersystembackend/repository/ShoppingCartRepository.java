package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByProductId(Long productId);
    // List<ShoppingCart> findByCartId(Long cartId);
}
