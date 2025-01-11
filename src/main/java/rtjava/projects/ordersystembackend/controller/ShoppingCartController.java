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

    // CREATE
    @PostMapping
    public ResponseEntity<ShoppingCartDto> addToCart(@RequestBody ShoppingCartDto cartDto) {
        ShoppingCartDto savedItem = cartService.addToCart(cartDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartDto> getCartItemById(@PathVariable Long id) {
        ShoppingCartDto cartDto = cartService.getCartItemById(id);
        return ResponseEntity.ok(cartDto);
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<ShoppingCartDto>> getAllCartItems() {
        List<ShoppingCartDto> cartItems = cartService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartDto> updateCartItem(@PathVariable Long id,
                                                          @RequestBody ShoppingCartDto cartDto) {
        ShoppingCartDto updatedItem = cartService.updateCartItem(id, cartDto);
        return ResponseEntity.ok(updatedItem);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long id) {
        cartService.deleteCartItem(id);
        return ResponseEntity.ok("Successfully deleted cart item " + id);
    }
}
