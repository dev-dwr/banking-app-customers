package com.customers.provider;

import com.customers.connector.AccountsConnector;
import com.customers.api.v1.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/*
    Class AccountsProvider
    is between controller and service (like repository)
* */
@Slf4j
@Service
public class AccountProvider {

    private final AccountsConnector accountsConnector;

    public AccountProvider(AccountsConnector accountsConnector) {
        this.accountsConnector = accountsConnector;
    }

    public List<AccountDto> getCustomerAccounts(Long customerId){

        List<AccountDto> result = accountsConnector.getAccountsList(customerId)
                .stream()
                .map(account -> {
                            AccountDto accountDto = new AccountDto();
                            accountDto.setId(account.getId());
                            accountDto.setNrb(account.getNrb());
                            accountDto.setCustomerId(account.getCustomerId());
                            accountDto.setCurrency(account.getCurrency());
                            accountDto.setAvailableFunds(account.getAvailableFunds());
                            return accountDto;
                        }
                ).collect(Collectors.toList());

        return result;


    }
}
