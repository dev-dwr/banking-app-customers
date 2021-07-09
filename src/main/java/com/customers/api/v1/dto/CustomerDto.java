package com.customers.api.v1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private Long customerId;
    private String firstName;
    private String lastName;
}
