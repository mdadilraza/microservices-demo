package com.eidiko.customer_service.dao;

import com.eidiko.customer_service.entity.Customer;
import com.eidiko.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository ;

    public Customer saveCustomer(Customer customer){

        return customerRepository.save(customer);

    }

    public Customer findCustomer(long id){
       return  customerRepository.findById(id).get();
    }

    public List<Customer> findAllCustomer(){
     return  customerRepository.findAll();
    }

    public Customer updateCustomer(long id ,Customer newCustomer){

        newCustomer.setId(id);
      return   saveCustomer(newCustomer);

    }

   public Customer deleteCustomer(long id){
     return   customerRepository.deleteById(id);
   }

}
