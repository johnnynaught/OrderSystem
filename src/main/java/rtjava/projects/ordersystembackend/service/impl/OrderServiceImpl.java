package rtjava.projects.ordersystembackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.OrderDto;
import rtjava.projects.ordersystembackend.entity.Order;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.OrderMapper;
import rtjava.projects.ordersystembackend.repository.OrderRepository;
import rtjava.projects.ordersystembackend.repository.ShoppingCartRepository;
import rtjava.projects.ordersystembackend.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ShoppingCartRepository shoppingCartRepository) {
        this.orderRepository = orderRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);

        shoppingCartRepository.deleteAll();
        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
        orderRepository.delete(order);
    }
}
