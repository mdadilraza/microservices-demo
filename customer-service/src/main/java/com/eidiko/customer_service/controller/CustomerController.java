package com.eidiko.customer_service.controller;

import com.eidiko.customer_service.GlobalResponse.ResponseStructure;
import com.eidiko.customer_service.entity.Customer;
import com.eidiko.customer_service.product.Product;
import com.eidiko.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    WebClient webClient;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/saveCustomer")
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/updateCustomer")
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(long id, Customer customer) {
        return customerService.updateService(id, customer);
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
        return customerService.findAllService();
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(long id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/findCustomerById")
    public ResponseEntity<ResponseStructure<Customer>> findCustomerById(long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/getProduct/{name}")
    public Product getProductByName(@PathVariable(value = "name") String name) {
        return customerService.getProductByName(name);
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return customerService.createProduct(product);
    }


    //webclient
    @GetMapping("/getProduct")
    public Product getProduct(String name) {

        return webClient.get()
                .uri("/findProductByName/{name}", name)
                .retrieve()
                .bodyToMono(Product.class)
                .block();

    }


    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return webClient.post().
                uri("/saveProduct")
                .bodyValue(product)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    @DeleteMapping("/deleteProduct{id}")
    public Product deleteProduct(@PathVariable(value = "id") long id){


        return webClient.delete()
                .uri("/deleteProduct{id}" ,id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();

    }


    //open feign


@GetMapping("/getProductByName/{name}")
    public Product findProductByName(@PathVariable("name") String name){

    System.out.println("finding product for customer " + name);

        return customerService.findProductByName(name);
    }


    @DeleteMapping("/removeProduct{id}")
    public ResponseEntity<ResponseStructure<Product>> removeProduct(@PathVariable(value = "id") long id) {
        return customerService.deleteProduct(id);
    }
}
