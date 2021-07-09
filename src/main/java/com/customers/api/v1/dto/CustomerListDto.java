package com.customers.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerListDto {
    List<CustomerDto> customerDtoList;
}
