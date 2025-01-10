package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    ProductDto getProductByID(Long productId);
    List<ProductDto> getAllProducts();
}
