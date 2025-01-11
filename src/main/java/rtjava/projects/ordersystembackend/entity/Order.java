package rtjava.projects.ordersystembackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                 // Primary key for the row

    private Long orderId;            // Logical order identifier (all rows with same orderId belong to the same 'order')
    private Long userId;             // ID of the user placing the order
    private Long productId;          // ID of the product in this particular row
    private Integer quantity;        // Quantity of the given product
    private Double singleProductPrice;  // The product price at the time of ordering (immutable)

    // No-argument constructor
    public Order() {
    }

    // All-arguments constructor
    public Order(Long id, Long orderId, Long userId, Long productId, Integer quantity, Double singleProductPrice) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.singleProductPrice = singleProductPrice;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSingleProductPrice() {
        return singleProductPrice;
    }

    public void setSingleProductPrice(Double singleProductPrice) {
        this.singleProductPrice = singleProductPrice;
    }
}
