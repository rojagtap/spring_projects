package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    String firstName, lastName;

    public Customer(){}

    public Customer(String first_name, String last_name) {
        this.firstName = first_name;
        this.lastName = last_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
