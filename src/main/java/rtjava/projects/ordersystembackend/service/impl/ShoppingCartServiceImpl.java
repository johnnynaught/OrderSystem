package rtjava.projects.ordersystembackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import rtjava.projects.ordersystembackend.entity.Product;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.ShoppingCartMapper;
import rtjava.projects.ordersystembackend.repository.ProductRepository;
import rtjava.projects.ordersystembackend.repository.ShoppingCartRepository;
import rtjava.projects.ordersystembackend.service.ShoppingCartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ShoppingCartDto addToCart(ShoppingCartDto cartDto) {
        // Convert the DTO to entity
        ShoppingCart cartItem = ShoppingCartMapper.mapToShoppingCart(cartDto);

        // 1) Look up current product price
        Product product = productRepository.findById(cartItem.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + cartItem.getProductId()));

        // 2) Calculate totalPrice = quantity * product's current price
        Double price = product.getPrice();
        Integer qty = cartItem.getQuantity();
        cartItem.setTotalPrice(price * qty);

        // 3) Save the item in DB
        ShoppingCart savedItem = cartRepository.save(cartItem);

        // 4) Convert entity back to DTO
        return ShoppingCartMapper.mapToShoppingCartDto(savedItem);
    }

    @Override
    public ShoppingCartDto updateCartItem(Long id, ShoppingCartDto cartDto) {
        // 1) Find the existing cart item
        ShoppingCart existingCartItem = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with ID: " + id));

        // 2) Update relevant fields from the DTO (including productId, quantity, etc.)
        existingCartItem.setCartId(cartDto.getCartId());
        existingCartItem.setUserId(cartDto.getUserId());
        existingCartItem.setProductId(cartDto.getProductId());
        existingCartItem.setQuantity(cartDto.getQuantity());

        // 3) Retrieve the product price again (in case the product changed or the price was updated)
        Product product = productRepository.findById(cartDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + cartDto.getProductId()));

        // 4) Recalculate the totalPrice using the new quantity (and/or new product, if changed)
        Double updatedPrice = product.getPrice() * existingCartItem.getQuantity();
        existingCartItem.setTotalPrice(updatedPrice);

        // 5) Save the updated cart item
        ShoppingCart updatedItem = cartRepository.save(existingCartItem);

        // 6) Convert entity back to DTO
        return ShoppingCartMapper.mapToShoppingCartDto(updatedItem);
    }

    @Override
    public ShoppingCartDto getCartItemById(Long id) {
        ShoppingCart cartItem = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with id: " + id));
        return ShoppingCartMapper.mapToShoppingCartDto(cartItem);
    }

    @Override
    public List<ShoppingCartDto> getAllCartItems() {
        List<ShoppingCart> cartItems = cartRepository.findAll();
        return cartItems.stream()
                .map(ShoppingCartMapper::mapToShoppingCartDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCartItem(Long id) {
        ShoppingCart cartItem = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found with id: " + id));
        cartRepository.delete(cartItem);
    }
}
