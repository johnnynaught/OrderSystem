package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    List<OrderDto> getAllOrders();
    void deleteOrder(Long id);
}