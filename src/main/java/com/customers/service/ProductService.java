package com.customers.service;

import com.customers.api.v1.dto.AccountDto;
import com.customers.api.v1.dto.CardDto;
import com.customers.provider.AccountProvider;
import com.customers.provider.CardProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    ProductService
    will allows us to download data of products
*/
@Service
@RequiredArgsConstructor
public class ProductService {

    private final AccountProvider accountProvider;
    private final CardProvider cardProvider;


    public List<AccountDto> findCustomerAccounts(Long customerId){
        return accountProvider.getCustomerAccounts(customerId);
    }

    public List<CardDto> findCustomerCards(Long customerId){
        return cardProvider.getCardList(customerId);
    }

}
