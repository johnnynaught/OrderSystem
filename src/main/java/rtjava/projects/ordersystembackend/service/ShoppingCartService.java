package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import java.util.List;

public interface ShoppingCartService {
    ShoppingCartDto addToCart(ShoppingCartDto cartDto);
    ShoppingCartDto updateCartItem(Long id, ShoppingCartDto cartDto);
    ShoppingCartDto getCartItemById(Long id);
    List<ShoppingCartDto> getAllCartItems();
    void deleteCartItem(Long id);

    // Additional methods if needed, e.g.:
    // List<ShoppingCartDto> getCartItemsByUserId(Long userId);
    // or logic to clear cart, etc.
}
