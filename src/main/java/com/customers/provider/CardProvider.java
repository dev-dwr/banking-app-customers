package com.customers.provider;

import com.customers.api.v1.dto.CardDto;
import com.customers.connector.CardConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardProvider {
    private final CardConnector connector;

    public List<CardDto> getCardList(Long customerId){
        return connector.getCardList(customerId)
                .stream()
                .map(card -> {
                    CardDto cardDto = new CardDto();
                    cardDto.setId(card.getId());
                    cardDto.setCreditCardNumber(card.getCreditCardNumber());
                    cardDto.setDebitCardNumber(card.getDebitCardNumber());
                    cardDto.setCustomerId(card.getCustomerId());
                    return cardDto;
                })
                .collect(Collectors.toList());
    }
}
