package rtjava.projects.ordersystembackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rtjava.projects.ordersystembackend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
