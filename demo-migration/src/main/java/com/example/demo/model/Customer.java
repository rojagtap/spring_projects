package com.example.demo.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;


@Entity
@Table(name = "customer")
@Document(value = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
//    @Field(name = "_id")
    private Long id;

    @Column(name = "firstname")
    @Field(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    @Field(name = "lastname")
    private String lastName;

}
