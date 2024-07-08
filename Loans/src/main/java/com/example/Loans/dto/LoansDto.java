package com.example.Loans.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {

    private Long id;
    private String mobileNumber;
    private String loanNumber;
    private Integer totalLoan;
    private Integer amountPaid;
    private Integer outstandingAmount;
}
