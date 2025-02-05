package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findById(Long id);

    Optional<User> findByEmail(String email);
}
