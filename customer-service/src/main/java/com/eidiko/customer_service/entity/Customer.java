package com.eidiko.customer_service.entity;

import com.eidiko.customer_service.product.Product;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")

public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id ;

    private String name;

    private long mobile;



}
