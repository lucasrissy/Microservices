package com.example.cards.service.impl;

import com.example.cards.dto.CardDto;
import com.example.cards.entities.Cards;
import com.example.cards.exceptions.ResourceNotFoundException;
import com.example.cards.mapper.CardMapper;
import com.example.cards.repository.CardRepository;
import com.example.cards.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardMapper mapper;

    @Override
    public void createdCard(CardDto dto) {

        if (dto == null){
            throw new RuntimeException("");
        }

        Cards cards = mapper.convertToEntity(new Cards(), dto);

        //verify if there is a same phone number

        Optional<Cards> optionalCards = cardRepository.findByMobileNumber(cards.getMobileNumber());

        if (optionalCards.isPresent()){
            System.out.println(String.format("The mobile number %s already exist!",cards.getMobileNumber()));
        }

        cardRepository.save(cards);

    }

    @Override
    public CardDto findCardByMobileNumber(String mobileNumber) {

        Cards cards = new Cards();

        cardRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("this number do not exist!!"));

        return mapper.convertToDTO(cardRepository.findByMobileNumber(mobileNumber).get(), new CardDto());
    }

    @Override
    public boolean updateCard(CardDto cardDto) {

        boolean isUpdate = false;

        Cards cards = new Cards();

        if (cardDto != null){
           cardRepository.findById(cardDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Card not found!"));

           cardRepository.save(mapper.convertToEntity(cards,cardDto));

           isUpdate = true;
        }
        return isUpdate;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {

        boolean isDelete = false;

        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new RuntimeException());
        if (cards != null){
            cardRepository.delete(cards);
            isDelete = true;
        }

        return isDelete;
    }
}
