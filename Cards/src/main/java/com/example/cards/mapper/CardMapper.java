package com.example.cards.mapper;

import com.example.cards.dto.CardDto;
import com.example.cards.entities.Cards;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public  Cards convertToEntity(Cards entity, CardDto dto){


        entity.setAvailableAmount(dto.getAvailableAmount());
        entity.setCardType(dto.getCardType());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setTotalLimit(dto.getTotalLimit());

        return entity;
    }

    public  CardDto convertToDTO(Cards entity, CardDto dto){

        dto.setAvailableAmount(entity.getAvailableAmount());
        dto.setCardType(entity.getCardType());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setTotalLimit(entity.getTotalLimit());

        return dto;
    }
}
