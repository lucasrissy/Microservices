package com.example.Loans.mapper;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public Loans converToEntity(Loans loans, LoansDto dto){

        loans.setLoanNumber(dto.getLoanNumber());
        loans.setTotalLoan(dto.getTotalLoan());
        loans.setMobileNumber(dto.getMobileNumber());
        loans.setAmountPaid(dto.getAmountPaid());
        loans.setOutstandingAmount(dto.getOutstandingAmount());


        return loans;
    }

    public LoansDto converToDto(Loans loans, LoansDto dto){

       dto.setAmountPaid(loans.getAmountPaid());
       dto.setTotalLoan(loans.getTotalLoan());
       dto.setOutstandingAmount(loans.getOutstandingAmount());
       dto.setLoanNumber(loans.getLoanNumber());
       dto.setMobileNumber(loans.getMobileNumber());

        return dto;
    }
}
