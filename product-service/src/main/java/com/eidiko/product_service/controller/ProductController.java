package com.eidiko.product_service.controller;


import com.eidiko.product_service.entity.Product;
import com.eidiko.product_service.responseStructure.ResponseStructure;
import com.eidiko.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        return productService.saveProduct(product);

    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
        return productService.findAllProduct();
    }

    @DeleteMapping("/deleteProduct{id}")
    public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable(value = "id") long id) {

        return productService.deleteProduct(id);
    }

    @GetMapping("/findProductByName/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable(value = "name") String name) {
        return productService.findProductByName(name);
    }


}
