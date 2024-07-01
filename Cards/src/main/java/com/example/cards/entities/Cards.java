package com.example.cards.entities;


import com.example.cards.util.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tb_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "total_limit")
    private Integer totalLimit;

    @Column(name = "available_amount")
    private Integer availableAmount;


}
