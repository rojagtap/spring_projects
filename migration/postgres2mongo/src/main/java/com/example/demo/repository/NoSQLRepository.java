package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface NoSQLRepository extends MongoRepository<Customer, String> {
}
