package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.ProductDto;
import rtjava.projects.ordersystembackend.entity.Product;

public class ProductMapper {

    // Map Product entity to ProductDto
    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getImage(),
                product.getCategory(),
                product.getQuantity()
        );
    }

    // Map ProductDto to Product entity
    public static Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage());
        product.setCategory(productDto.getCategory());
        product.setQuantity(productDto.getQuantity());
        return product;
    }
}
