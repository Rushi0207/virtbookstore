package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUser_Id(Long id);
}
