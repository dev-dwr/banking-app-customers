package com.customers.connector;

import com.customers.api.v1.dto.AccountDto;
import com.customers.api.v1.dto.AccountsListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("accounts") //name of microservice
public interface AccountsConnector {

    @GetMapping("/v1/accounts")
    List<AccountDto> getAccountsList(@RequestParam("customerId") Long customerId);


}
