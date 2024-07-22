package com.eidiko.customer_service.product;

import com.eidiko.customer_service.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Customer customer;
    private Product product;
}
