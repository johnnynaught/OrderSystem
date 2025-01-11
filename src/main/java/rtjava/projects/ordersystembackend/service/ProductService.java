package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long productId, ProductDto updatedProductDto);
    ProductDto getProductByID(Long productId);
    List<ProductDto> getAllProducts();
    void deleteProduct(Long productId);
}
