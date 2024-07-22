package com.eidiko.customer_service.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String prodName ;

    private double prodPrice ;

    private double prodRating ;

    private String prodType ;
}
