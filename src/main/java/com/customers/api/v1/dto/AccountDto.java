package com.customers.api.v1.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class AccountDto {
    private Long id;
    private String nrb;
    private Long customerId;
    private String currency;
    private Long availableFunds;
}
