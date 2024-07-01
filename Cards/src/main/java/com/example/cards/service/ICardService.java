package com.example.cards.service;

import com.example.cards.dto.CardDto;
import com.example.cards.entities.Cards;

public interface ICardService {

    void createdCard (CardDto cards);

    CardDto findCardByMobileNumber(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);
}
