package rtjava.projects.ordersystembackend.dto;

public class OrderDto {
    private Long id;                // primary key in the DB
    private Long orderId;           // logical identifier for the entire order
    private Long userId;            // ID of the user who placed the order
    private Long productId;         // product ID for this row
    private Integer quantity;       // how many units of the product
    private Double singleProductPrice; // price at the time of ordering

    public OrderDto() {
    }

    public OrderDto(Long id, Long orderId, Long userId, Long productId,
                    Integer quantity, Double singleProductPrice) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.singleProductPrice = singleProductPrice;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
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

    public Double getSingleProductPrice() {
        return singleProductPrice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public void setSingleProductPrice(Double singleProductPrice) {
        this.singleProductPrice = singleProductPrice;
    }
}
