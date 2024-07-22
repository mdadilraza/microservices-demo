package com.eidiko.product_service.dao;

import com.eidiko.product_service.entity.Product;
import com.eidiko.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ProductDao {

    @Autowired
    ProductRepository productRepository ;
   //saveProduct()
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //findProductByName

    public Product findProductByName(String name) {
        return productRepository.findByProdName(name);

    }

    //findAllProduct()

    public List<Product> findAllProduct(){
      return   productRepository.findAll();
    }

    //updateProduct()

    public Product updateProduct(Product product){

      return   productRepository.save(product);
    }

    //deleteProduct()

    public Product deleteProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
         productRepository.deleteById(id);
        return product.get();
    }


}
