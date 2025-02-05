package com.example.VirtualBookStore.Services;

import com.example.VirtualBookStore.DTO.OrderRequest;
import com.example.VirtualBookStore.Models.Book;
import com.example.VirtualBookStore.Models.Order;
import com.example.VirtualBookStore.Models.OrderItem;
import com.example.VirtualBookStore.Models.User;
import com.example.VirtualBookStore.Repository.BookRepository;
import com.example.VirtualBookStore.Repository.OrderRepository;
import com.example.VirtualBookStore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(()-> new RuntimeException("user Not  found"));
        List<OrderItem> orderItems = orderRequest.getItems().stream().map(item -> {
            Book book = bookRepository.findById(item.getBoookId())
                    .orElseThrow(()-> new RuntimeException("book not found"));
            if(book.getStock() < item.getQuantity()){
                throw new RuntimeException("Insuffiecient stock for book: "+book.getTitle());
            }

            book.setStock(book.getStock() - item.getQuantity());
            return new OrderItem(book, item.getQuantity(), (double)(book.getPrice()*item.getQuantity()));
        }).toList();
        double totalAmount = orderItems.stream().mapToDouble(OrderItem::getPrice).sum();

        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        order.setStatus("pending");
        order.setCreatedAt(java.time.Instant.now().toString());
        return orderRepository.save(order);
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));
    }

    public List<Order> getOrderByUser(Long id) {
        return orderRepository.findByUser_Id(id);
    }

    public Order UpdateOrderStatus(String orderId, String status) {
        Order order = getOrderById(orderId);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
