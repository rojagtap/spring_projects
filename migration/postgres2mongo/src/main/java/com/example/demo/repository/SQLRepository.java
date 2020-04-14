package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface SQLRepository extends CrudRepository<Customer, Long> {
}
