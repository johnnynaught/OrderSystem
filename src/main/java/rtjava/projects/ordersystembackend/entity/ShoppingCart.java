package rtjava.projects.ordersystembackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;     // ID of the product
    private String title;       // Product name
    private String image;       // Product image URL
    private Double price;       // Product unit price
    private Integer quantity;   // Quantity of the product

    // Constructors
    public ShoppingCart() {
    }

    public ShoppingCart(Long productId, String title, String image, Double price, Integer quantity) {
        this.productId = productId;
        this.title = title;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
