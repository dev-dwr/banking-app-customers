package com.customers.api.v1.dto;

import com.customers.api.v1.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class AccountsListDto {
    List<AccountDto> accountsList;
}
