package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.OrderItemDto;
import rtjava.projects.ordersystembackend.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItemDto mapToOrderItemDto(OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.getProductId(),
                orderItem.getQuantity(),
                orderItem.getSingleProductPrice()
        );
    }

    public static OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemDto.getProductId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setSingleProductPrice(orderItemDto.getSingleProductPrice());
        return orderItem;
    }
}
