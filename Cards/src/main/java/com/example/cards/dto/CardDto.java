package com.example.cards.dto;

import com.example.cards.util.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private Long id;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "this is required")
    private CardType cardType;

    @NotEmpty(message = "this is required")
    private Integer totalLimit;

    @NotBlank(message = "this is required")
    private Integer availableAmount;
}
