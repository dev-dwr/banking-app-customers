package com.customers.service;

import com.customers.api.v1.dto.CustomerDto;
import com.customers.api.v1.mapper.CustomerMapper;
import com.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerDto getCustomerById(Long customerId){
        return customerMapper.customerToCustomerDto(customerRepository.findCustomerByCustomerId(customerId));
    }
}
