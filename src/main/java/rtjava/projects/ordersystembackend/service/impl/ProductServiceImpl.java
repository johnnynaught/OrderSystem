package rtjava.projects.ordersystembackend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.ProductDto;
import rtjava.projects.ordersystembackend.entity.Product;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.ProductMapper;
import rtjava.projects.ordersystembackend.repository.ProductRepository;
import rtjava.projects.ordersystembackend.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    // Manual constructor-based injection
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProductDto) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        product.setTitle(updatedProductDto.getTitle());
        product.setPrice(updatedProductDto.getPrice());
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductByID(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        productRepository.deleteById(productId);
    }

}
