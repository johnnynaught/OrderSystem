package rtjava.projects.ordersystembackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtjava.projects.ordersystembackend.dto.ProductDto;
import rtjava.projects.ordersystembackend.service.ProductService;

import java.util.List;

/**
 * A REST controller that handles all product-related HTTP requests.
 * It exposes various endpoints to create, read, update, and delete products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Constructor-based injection of the ProductService.
     * Spring will automatically wire an instance of ProductService here
     * as long as there's a bean that implements that interface.
     *
     * @param productService the service that contains all business logic for managing products
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Create a new product.
     * Expects a JSON representation of ProductDto in the request body.
     * Returns the saved product along with an HTTP 201 (Created) status.
     *
     * @param productDto the product data to be created
     * @return a ResponseEntity containing the created ProductDto and 201 status
     */
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /**
     * Retrieve a single product by its ID.
     * This endpoint maps to GET /api/products/{id}.
     *
     * @param productId the ID of the product to retrieve
     * @return a ResponseEntity containing the ProductDto if found, or an appropriate error if not
     */
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductByID(@PathVariable("id") Long productId) {
        ProductDto productDto = productService.getProductByID(productId);
        return ResponseEntity.ok(productDto);
    }

    /**
     * Retrieve a list of all products.
     * Maps to GET /api/products with no path variable.
     *
     * @return a ResponseEntity containing a List of all ProductDto objects
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Update an existing product identified by its ID.
     * Expects a JSON representation of ProductDto in the request body with updated fields.
     *
     * @param productId         the ID of the product to be updated
     * @param updatedProductDto the updated product data
     * @return a ResponseEntity containing the updated ProductDto
     */
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId,
                                                    @RequestBody ProductDto updatedProductDto) {
        ProductDto productDto = productService.updateProduct(productId, updatedProductDto);
        return ResponseEntity.ok(productDto);
    }

    /**
     * Delete an existing product identified by its ID.
     * Maps to DELETE /api/products/{id}.
     *
     * @param productId the ID of the product to be deleted
     * @return a ResponseEntity with a message confirming the deletion
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Successfully deleted product " + productId);
    }
}
