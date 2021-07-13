package com.customers.api.v1.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerProducts {
    private Long customerId;
    private String fullName;
    private List<AccountDto> accounts;

}
