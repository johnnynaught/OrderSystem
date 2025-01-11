package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.ShoppingCartDto;
import rtjava.projects.ordersystembackend.entity.ShoppingCart;

public class ShoppingCartMapper {

    public static ShoppingCart mapToShoppingCart(ShoppingCartDto cartDto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setId(cartDto.getId());
        cart.setCartId(cartDto.getCartId());
        cart.setUserId(cartDto.getUserId());
        cart.setProductId(cartDto.getProductId());
        cart.setQuantity(cartDto.getQuantity());
        cart.setTotalPrice(cartDto.getTotalPrice());
        return cart;
    }

    public static ShoppingCartDto mapToShoppingCartDto(ShoppingCart cart) {
        ShoppingCartDto cartDto = new ShoppingCartDto();
        cartDto.setId(cart.getId());
        cartDto.setCartId(cart.getCartId());
        cartDto.setUserId(cart.getUserId());
        cartDto.setProductId(cart.getProductId());
        cartDto.setQuantity(cart.getQuantity());
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }
}
