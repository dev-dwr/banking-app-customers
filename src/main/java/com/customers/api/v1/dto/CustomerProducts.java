package com.customers.api.v1.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CustomerProducts {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;
}
