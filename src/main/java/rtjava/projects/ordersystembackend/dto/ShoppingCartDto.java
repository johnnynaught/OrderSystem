package rtjava.projects.ordersystembackend.dto;

public class ShoppingCartDto {
    private Long id;           // primary key in DB
    private Long cartId;       // logical identifier for the cart
    private Long userId;       // user ID who owns the cart
    private Long productId;    // product ID for this row
    private Integer quantity;  // how many units of the product in the cart
    private Double totalPrice; // quantity * product's current price

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, Long cartId, Long userId, Long productId,
                           Integer quantity, Double totalPrice) {
        this.id = id;
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
