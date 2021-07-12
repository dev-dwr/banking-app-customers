package com.customers.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private Long customerId;
    private Double availableFunds;
}
