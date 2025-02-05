package com.example.VirtualBookStore.Controllers;

import com.example.VirtualBookStore.DTO.OrderRequest;
import com.example.VirtualBookStore.Models.Order;
import com.example.VirtualBookStore.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    private ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest){
        Order newOdr = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(newOdr, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    private ResponseEntity<Order> getOrderById(@PathVariable String id){
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/user/{userid}")
    private ResponseEntity<List<Order>> getOrderByUser(@PathVariable Long id){
        List<Order> orders = orderService.getOrderByUser(id);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/Status")
    private ResponseEntity<Order> updateOrderStatus(@PathVariable String orderId, @RequestParam String status){
        Order updateOrder = orderService.UpdateOrderStatus(orderId, status);

        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }
}
