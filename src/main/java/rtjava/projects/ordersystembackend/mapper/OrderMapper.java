package rtjava.projects.ordersystembackend.mapper;

import rtjava.projects.ordersystembackend.dto.OrderDto;
import rtjava.projects.ordersystembackend.entity.Order;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setOrderId(orderDto.getOrderId());
        order.setUserId(orderDto.getUserId());
        order.setProductId(orderDto.getProductId());
        order.setQuantity(orderDto.getQuantity());
        order.setSingleProductPrice(orderDto.getSingleProductPrice());
        return order;
    }

    public static OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrderId(order.getOrderId());
        orderDto.setUserId(order.getUserId());
        orderDto.setProductId(order.getProductId());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setSingleProductPrice(order.getSingleProductPrice());
        return orderDto;
    }
}
