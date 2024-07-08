package com.example.Loans.service;

import com.example.Loans.dto.LoansDto;

import java.util.Optional;

public interface IServiceLoans {

    void createLoan(LoansDto dto);

    LoansDto fetchLoan (String mobileNumber);
}
