package com.customers.service;

import com.customers.api.v1.dto.AccountDto;
import com.customers.provider.AccountProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    ProductService
    will allows us to download data of products
*/
@Service
public class ProductService {

    private final AccountProvider accountProvider;

    public ProductService(AccountProvider accountProvider) {
        this.accountProvider = accountProvider;
    }

    public List<AccountDto> findCustomerAccounts(Long customerId){
        return accountProvider.getCustomerAccounts(customerId);
    }
}
