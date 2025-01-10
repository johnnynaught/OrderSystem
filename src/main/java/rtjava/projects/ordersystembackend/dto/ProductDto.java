package rtjava.projects.ordersystembackend.dto;

public class ProductDto {

    private Long id;
    private String name;
    private Double price;

    // No-argument constructor
    public ProductDto() {
    }

    // All-arguments constructor
    public ProductDto(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
