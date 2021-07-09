package com.customers.repository;

import com.customers.api.v1.dto.CustomerDto;
import com.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.customerId = ?1")
    Customer findCustomerByCustomerId(Long id);
}
