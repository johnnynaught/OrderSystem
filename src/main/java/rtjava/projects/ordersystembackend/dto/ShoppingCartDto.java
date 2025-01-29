package rtjava.projects.ordersystembackend.dto;

public class ShoppingCartDto {

    private Long productId;
    private String title;
    private String image;
    private Double price;
    private Integer quantity;

    // Constructors
    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long productId, String title, String image, Double price, Integer quantity) {
        this.productId = productId;
        this.title = title;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
