package com.customers.controllers.v1;

import com.customers.api.v1.dto.CustomerDto;
import com.customers.api.v1.dto.CustomerProducts;
import com.customers.api.v1.dto.AccountDto;
import com.customers.service.CustomerService;
import com.customers.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CustomersController {

    private final CustomerService customerService;
    private final ProductService productService;
    @Value("${app.allow-get-customers}")
    private boolean allowGetCustomers;



    @GetMapping("/{customerId}")
    public CustomerDto findCustomerById(@PathVariable("customerId") Long customerId){
        if(!allowGetCustomers){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }
        return  customerService.getCustomerById(customerId);
    }

    @GetMapping("/{customerId}/products")
    public CustomerProducts getCustomerProducts(@PathVariable Long customerId){

        CustomerDto customerDto = customerService.getCustomerById(customerId);

        List<AccountDto> customerAccounts = productService.findCustomerAccounts(customerId);

        return CustomerProducts.builder()
                .customerId(customerDto.getCustomerId())
                .fullName(customerDto.getFirstName() + " " + customerDto.getLastName())
                .accounts(customerAccounts)
                .build();
    }

}
