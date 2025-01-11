package rtjava.projects.ordersystembackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // Primary key for the cart row

    private Long cartId;            // Logical cart identifier (multiple rows can share the same cartId)
    private Long userId;            // ID of the user who owns this cart
    private Long productId;         // ID of the product added to the cart
    private Integer quantity;       // Quantity of the product in the cart
    private Double totalPrice;      // The total price (quantity * product's current price)

    // No-argument constructor
    public ShoppingCart() {
    }

    // All-arguments constructor
    public ShoppingCart(Long id, Long cartId, Long userId, Long productId, Integer quantity, Double totalPrice) {
        this.id = id;
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
