package rtjava.projects.ordersystembackend.dto;

public class OrderItemDto {
    private Long productId; // Product ID
    private Integer quantity; // Quantity of the product
    private Double singleProductPrice; // Price of the product at the time of order

    // No-argument constructor
    public OrderItemDto() {
    }

    // All-arguments constructor
    public OrderItemDto(Long productId, Integer quantity, Double singleProductPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.singleProductPrice = singleProductPrice;
    }

    // Getters and Setters
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
