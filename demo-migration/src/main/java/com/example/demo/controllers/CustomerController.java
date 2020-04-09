package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.repository.NoSQLRepository;
import com.example.demo.repository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/migration")
public class CustomerController {

    private final SQLRepository sqlRepository;
    private final NoSQLRepository noSQLRepository;

    @Autowired
    public CustomerController(SQLRepository sqlRepository, NoSQLRepository noSQLRepository) {
        this.sqlRepository = sqlRepository;
        this.noSQLRepository = noSQLRepository;

        this.noSQLRepository.save(
          new Customer(1L, "Test First Name", "Test Last Name")
        );
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        Customer customer = sqlRepository.findById(id).orElse(null);
        // do whatever changes in customer
        assert customer != null;
        noSQLRepository.save(customer);
        return customer.toString();
    }
}
