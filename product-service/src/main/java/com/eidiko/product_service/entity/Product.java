package com.eidiko.product_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String prodName ;

    private double prodPrice ;

    private double prodRating ;

    private String prodType ;





}
