package rtjava.projects.ordersystembackend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for the order

    private Long userId;  // ID of the user placing the order

    private LocalDateTime orderTime;  // Timestamp of the order

    private Double totalPrice;  // Total price of the order

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;  // List of order items

    // No-argument constructor
    public Order() {
    }

    // All-arguments constructor
    public Order(Long id, Long userId, LocalDateTime orderTime, Double totalPrice, List<OrderItem> items) {
        this.id = id;
        this.userId = userId;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
