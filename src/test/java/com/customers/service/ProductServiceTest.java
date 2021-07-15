package com.customers.service;

import com.customers.api.v1.dto.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com:accounts:+:stubs:9000"
        }
)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findCustomerAccounts() {
        //given
        Long customerId = 123456L;

        //when
        List<AccountDto> accountDtos = productService.findCustomerAccounts(customerId);

        //then

        assertEquals(1, accountDtos.size());

        assertEquals(123456, accountDtos.get(0).getCustomerId());
        assertEquals(1, accountDtos.get(0).getId());
        assertEquals("PLN", accountDtos.get(0).getCurrency());
        assertEquals("72249000059957936727967706", accountDtos.get(0).getNrb());
        assertEquals(65245455445455.3, accountDtos.get(0).getAvailableFunds());
    }
}