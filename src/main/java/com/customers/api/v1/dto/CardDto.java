package com.customers.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private Long id;
    private Integer creditCardNumber;
    private Integer debitCardNumber;
    private Long customerId;
}
