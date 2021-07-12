package com.customers.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountsListDto {
    List<AccountDto> accountsList;
}
