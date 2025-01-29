package rtjava.projects.ordersystembackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import rtjava.projects.ordersystembackend.service.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {

    private final ShoppingCartService cartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCartDto> addToCart(@RequestBody ShoppingCartDto cartDto) {
        ShoppingCartDto savedItem = cartService.addToCart(cartDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartDto>> getAllCartItems() {
        List<ShoppingCartDto> cartItems = cartService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long productId) {
        cartService.removeCartItem(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> calculateTotalAmount() {
        double totalAmount = cartService.calculateTotalAmount();
        return ResponseEntity.ok(totalAmount);
    }

    @GetMapping("/count")
    public ResponseEntity<Double> calculateCount() {
        double count = cartService.calculateCount();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitOrder() {
        cartService.submitOrder(); // Logic for submitting the order
        return ResponseEntity.ok("Order submitted successfully.");
    }

}

