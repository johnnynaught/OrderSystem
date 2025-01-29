package rtjava.projects.ordersystembackend.dto;

public class ProductDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private Integer quantity;

    // No-argument constructor
    public ProductDto() {
    }

    // All-arguments constructor
    public ProductDto(Long id, String title, String description, Double price, String image, String category, Integer quantity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
        this.quantity = quantity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
