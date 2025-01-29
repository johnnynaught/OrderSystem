package rtjava.projects.ordersystembackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.ShoppingCartMapper;
import rtjava.projects.ordersystembackend.repository.ShoppingCartRepository;
import rtjava.projects.ordersystembackend.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository cartRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public ShoppingCartDto addToCart(ShoppingCartDto cartDto) {
        // Find the product in the cart
        ShoppingCart existingCartItem = cartRepository.findByProductId(cartDto.getProductId());

        if (existingCartItem != null) {
            // Update quantity and save
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartDto.getQuantity());
            cartRepository.save(existingCartItem);

            // Return updated cart item
            return ShoppingCartMapper.mapToShoppingCartDto(existingCartItem);
        } else {
            // Create a new cart item
            ShoppingCart newCartItem = new ShoppingCart(
                    cartDto.getProductId(),
                    cartDto.getTitle(),
                    cartDto.getImage(),
                    cartDto.getPrice(),
                    cartDto.getQuantity()
            );

            // Save the new item
            ShoppingCart savedItem = cartRepository.save(newCartItem);

            // Return the new cart item
            return ShoppingCartMapper.mapToShoppingCartDto(savedItem);
        }
    }

    @Override
    public List<ShoppingCartDto> getAllCartItems() {
        return cartRepository.findAll().stream()
                .map(ShoppingCartMapper::mapToShoppingCartDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeCartItem(Long productId) {
        // Find the product in the cart
        ShoppingCart cartItem = cartRepository.findByProductId(productId);
        // Check if the product exists
        if (cartItem != null) {
            cartRepository.delete(cartItem); // Remove the product from the cart
        } else {
            throw new ResourceNotFoundException("Product not found in the cart with ID: " + productId);
        }
    }


    @Override
    public double calculateTotalAmount() {
        return cartRepository.findAll().stream()
                .mapToDouble(cartItem -> cartItem.getPrice() * cartItem.getQuantity())
                .sum();
    }

    @Override
    public int calculateCount() {
        return cartRepository.findAll().stream()
                .mapToInt(ShoppingCart::getQuantity) // Sum up the quantity of each item
                .sum();
    }


    @Override
    public void submitOrder() {
        // Logic to process the order and clear the cart
        List<ShoppingCart> cartItems = cartRepository.findAll();
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty. Cannot submit an order.");
        }
        // Logic to create an order, e.g., save to an `Order` table
        // Clear the cart after processing the order
        cartRepository.deleteAll(cartItems);
    }

}
