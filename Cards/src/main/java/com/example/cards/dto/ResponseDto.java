package com.example.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMgs;
}
