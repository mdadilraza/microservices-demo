package com.eidiko.customer_service.repository;

import com.eidiko.customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
  Customer  deleteById(long id);
}
