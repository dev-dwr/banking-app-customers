package com.customers.connector;

import com.customers.api.v1.dto.AccountDto;
import com.customers.api.v1.dto.CardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;


@FeignClient(value = "accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    List<AccountDto> getAccountsList(@RequestParam("customerId") Long customerId);
}
@Service
@Slf4j
class AccountsConnectorFallback implements AccountsConnector{
    @Override
    public List<AccountDto> getAccountsList(Long customerId) {
        log.warn("cannot get accounts for customerId: " + customerId);
        return Collections.emptyList();
    }
}


