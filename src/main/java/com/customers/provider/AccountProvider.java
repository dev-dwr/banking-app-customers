package com.customers.provider;

import com.customers.connector.AccountsConnector;
import com.customers.api.v1.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/*
    Class AccountsProvider
    is between controller and service (like repository)
* */
@Service
@RequiredArgsConstructor
public class AccountProvider {

    private final AccountsConnector accountsConnector;

    public List<AccountDto> getCustomerAccounts(Long customerId){
        return accountsConnector.getAccounts(customerId)
                .getAccountsList()
                .stream()
                .map(account -> {
                            AccountDto accountDto = new AccountDto();
                                    accountDto.setCustomerId(account.getId());
                                    accountDto.setNrb(account.getNrb());
                                    accountDto.setCustomerId(account.getCustomerId());
                                    accountDto.setCurrency(account.getCurrency());
                                    accountDto.setAvailableFunds(account.getAvailableFunds());
                                     return accountDto;
                        }
                    ).collect(Collectors.toList());


    }
}
