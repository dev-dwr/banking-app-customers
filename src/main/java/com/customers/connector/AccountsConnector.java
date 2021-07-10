package com.customers.connector;

import com.customers.api.v1.dto.AccountsListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("accounts") //name of microservice
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    AccountsListDto getAccounts(@RequestParam Long customerId);

}