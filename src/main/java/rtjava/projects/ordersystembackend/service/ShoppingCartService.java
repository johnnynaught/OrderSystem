package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartService {
    // Add or update a product in the cart
    ShoppingCartDto addToCart(ShoppingCartDto cartDto);

    // Get all cart items
    List<ShoppingCartDto> getAllCartItems();

    // Remove a product from the cart by productId
    void removeCartItem(Long productId);

    // Calculate the total amount in the cart
    double calculateTotalAmount();
    int calculateCount();

    void submitOrder();
}
