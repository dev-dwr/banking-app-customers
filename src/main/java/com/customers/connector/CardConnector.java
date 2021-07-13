package com.customers.connector;

import com.customers.api.v1.dto.CardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(value = "cards", fallback = CardsConnectorFallback.class)
public interface CardConnector{
    @GetMapping("/v1/cards/{customerId}")
    List<CardDto> getCardList(@PathVariable("customerId") Long customerId);
}

@Service
@Slf4j
class CardsConnectorFallback implements CardConnector{
    @Override
    public List<CardDto> getCardList(Long customerId) {
        log.warn("cannot find customer of id " + customerId);
        return Collections.emptyList();
    }
}