package rtjava.projects.ordersystembackend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Long id; // Order ID
    private Long userId; // User ID who placed the order
    private LocalDateTime orderTime; // Order time
    private Double totalPrice; // Total price of the order
    private List<OrderItemDto> items; // List of items in the order

    // No-argument constructor
    public OrderDto() {
    }

    // All-arguments constructor
    public OrderDto(Long id, Long userId, LocalDateTime orderTime, Double totalPrice, List<OrderItemDto> items) {
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

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
