package com.example.Loans.service;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import com.example.Loans.mapper.LoanMapper;
import com.example.Loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoansService implements IServiceLoans{

    public LoansRepository repository;
    public LoanMapper loanMapper;

    @Override
    public void createLoan(LoansDto dto) {

        Loans loans = new Loans();

        if (!repository.findByMobileNumber(dto.getMobileNumber()).isPresent()){

           loans = loanMapper.converToEntity(loans,dto);

           repository.save(loans);
        }else {
            System.out.println("throw a exception");
        }
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {

        if (!repository.findByMobileNumber(mobileNumber).isPresent()){
              new Exception();
        }

        return loanMapper.converToDto(repository.findByMobileNumber(mobileNumber).get(),new LoansDto()) ;
    }
}
