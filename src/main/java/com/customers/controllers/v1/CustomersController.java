package com.customers.controllers.v1;

import com.customers.api.v1.dto.CustomerDto;
import com.customers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("v1/customers")
@RefreshScope
@RequiredArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @Value("${app.allow-get-customers}")
    private boolean allowGetCustomers;

    @GetMapping("/{customerId}")
    public CustomerDto getCustomerById(@PathVariable("customerId") Long customerId){
        if(!allowGetCustomers){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customers is disabled");
        }
        return  customerService.getCustomerById(customerId);
    }
}
