package com.eidiko.product_service.service;

import com.eidiko.product_service.dao.ProductDao;
import com.eidiko.product_service.entity.Product;
import com.eidiko.product_service.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao ;

    public ResponseEntity<Product> saveProduct(Product product){

       return new ResponseEntity<>(productDao.saveProduct(product),HttpStatus.CREATED);

    }



    public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product){
        ResponseStructure<Product> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SuccessFully product updated into Database");
        responseStructure.setData(productDao.updateProduct(product));
        return new ResponseEntity<>(responseStructure , HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<Product>>>  findAllProduct(){

        ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.FOUND.value());
        responseStructure.setMessage("SuccessFully product fetched from  Database");
        responseStructure.setData(productDao.findAllProduct());
        return new ResponseEntity<>(responseStructure , HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<Product>> deleteProduct(long id){
        ResponseStructure<Product> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SuccessFully product deleted from Database");
        responseStructure.setData(productDao.deleteProduct(id));
        return new ResponseEntity<>(responseStructure , HttpStatus.OK);
    }

    public ResponseEntity<Product> findProductByName(String name){

        System.out.println("finding product for customer " + name);
       return new ResponseEntity<>(productDao.findProductByName(name),HttpStatus.OK);

    }

}
