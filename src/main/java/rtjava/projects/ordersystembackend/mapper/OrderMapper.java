package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.OrderDto;
import rtjava.projects.ordersystembackend.entity.Order;

import java.util.stream.Collectors;

public class OrderMapper {

    // Convert Order entity to OrderDto
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUserId(),
                order.getOrderTime(),
                order.getTotalPrice(),
                order.getItems().stream()
                        .map(OrderItemMapper::mapToOrderItemDto)
                        .collect(Collectors.toList())
        );
    }

    // Convert OrderDto to Order entity
    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setUserId(orderDto.getUserId());
        order.setOrderTime(orderDto.getOrderTime());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setItems(orderDto.getItems().stream()
                .map(OrderItemMapper::mapToOrderItem)
                .peek(orderItem -> orderItem.setOrder(order)) // Set the parent order
                .collect(Collectors.toList()));
        return order;
    }
}
