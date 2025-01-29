package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;

public class ShoppingCartMapper {

    // Map ShoppingCart entity to ShoppingCartDto
    public static ShoppingCartDto mapToShoppingCartDto(ShoppingCart cart) {
        return new ShoppingCartDto(
                cart.getProductId(),
                cart.getTitle(),
                cart.getImage(),
                cart.getPrice(),
                cart.getQuantity()
        );
    }

    // Map ShoppingCartDto to ShoppingCart entity
    public static ShoppingCart mapToShoppingCart(ShoppingCartDto cartDto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setProductId(cartDto.getProductId());
        cart.setTitle(cartDto.getTitle());
        cart.setImage(cartDto.getImage());
        cart.setPrice(cartDto.getPrice());
        cart.setQuantity(cartDto.getQuantity());
        return cart;
    }
}
