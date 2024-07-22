package com.eidiko.customer_service.feignclient;

import com.eidiko.customer_service.GlobalResponse.ResponseStructure;
import com.eidiko.customer_service.product.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE" )

public interface ProductClient {

    @GetMapping("/findProductByName/{name}")

    Product findProductByName(@PathVariable("name") String name);


    @DeleteMapping("/deleteProduct{id}")
     ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable(value = "id") long id);
}
