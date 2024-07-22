package com.eidiko.customer_service.service;

import com.eidiko.customer_service.dao.CustomerDao;
import com.eidiko.customer_service.GlobalResponse.ResponseStructure;
import com.eidiko.customer_service.entity.Customer;
import com.eidiko.customer_service.feignclient.ProductClient;
import com.eidiko.customer_service.product.Product;
import com.eidiko.customer_service.product.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    private ProductClient productClient ;

    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer){

        ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.CREATED.value());
        responseStructure.setMessage("SuccessFully customer inserted into Database");
        responseStructure.setData(customerDao.saveCustomer(customer));
        return new ResponseEntity<>(responseStructure , HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Customer>> updateService(long id ,Customer customer){
        ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SuccessFully customer updated into Database");
        responseStructure.setData(customerDao.updateCustomer(id ,customer));
        return new ResponseEntity<>(responseStructure , HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<List<Customer>>>  findAllService(){

        ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.FOUND.value());
        responseStructure.setMessage("SuccessFully customer fetched from  Database");
        responseStructure.setData(customerDao.findAllCustomer());
        return new ResponseEntity<>(responseStructure , HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(long id){
        ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SuccessFully customer deleted from Database");
        responseStructure.setData(customerDao.deleteCustomer(id));
        return new ResponseEntity<>(responseStructure , HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Customer>> findCustomerById(long id){
        ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.FOUND.value());
        responseStructure.setMessage("SuccessFully customer fetched from  Database");
        responseStructure.setData(customerDao.findCustomer(id));
        return new ResponseEntity<>(responseStructure , HttpStatus.FOUND);
    }


    @Autowired
    RestTemplate restTemplate;

    Response response = new Response();
    public static final String PRODUCT_SERVICE_URL ="http://localhost:8081/";
    public Product getProductByName(String name){

        String url =PRODUCT_SERVICE_URL + "findProductByName/{name}";
        ResponseEntity<Product> responseOfProduct = restTemplate.getForEntity(url,Product.class,name);


        //return responseOfProduct.getBody();
       // return restTemplate.getForObject(url, Product.class,name);
        if(responseOfProduct.getStatusCode().value() ==200){
            Product body = responseOfProduct.getBody();
            response.setProduct(body);
            return body;
        }

        return null;


    }

    public Product createProduct(Product product){
        String url=PRODUCT_SERVICE_URL +"saveProduct";

       return restTemplate.postForObject(url,product,Product.class);
    }



    //AddressClient implementation

 public Product findProductByName(String name){

      return productClient.findProductByName(name);

 }

    @DeleteMapping("/deleteProduct{id}")
    public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable(value = "id") long id) {
        return productClient.deleteProduct(id);
    }



}
