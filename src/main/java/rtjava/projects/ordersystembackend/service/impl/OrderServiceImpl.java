package rtjava.projects.ordersystembackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.OrderDto;
import rtjava.projects.ordersystembackend.entity.Order;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.OrderMapper;
import rtjava.projects.ordersystembackend.repository.OrderRepository;
import rtjava.projects.ordersystembackend.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        // Convert DTO to entity
        Order order = OrderMapper.mapToOrder(orderDto);
        // Save in DB
        Order savedOrder = orderRepository.save(order);
        // Convert entity back to DTO
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto updatedOrderDto) {
        // Find the order, throw if not found
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

        // Update fields
        order.setOrderId(updatedOrderDto.getOrderId());
        order.setUserId(updatedOrderDto.getUserId());
        order.setProductId(updatedOrderDto.getProductId());
        order.setQuantity(updatedOrderDto.getQuantity());
        order.setSingleProductPrice(updatedOrderDto.getSingleProductPrice());

        // Save changes
        Order savedOrder = orderRepository.save(order);
        // Convert to DTO
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
}
