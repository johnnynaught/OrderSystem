package rtjava.projects.ordersystembackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for the order item

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  // Reference to the parent order

    private Long productId;  // ID of the product in the order

    private Integer quantity;  // Quantity of the product

    private Double singleProductPrice;  // Price of the product at the time of order

    // No-argument constructor
    public OrderItem() {
    }

    // All-arguments constructor
    public OrderItem(Long id, Order order, Long productId, Integer quantity, Double singleProductPrice) {
        this.id = id;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
