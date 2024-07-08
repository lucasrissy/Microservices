package com.example.Loans.controller;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.service.IServiceLoans;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api")
@AllArgsConstructor
public class LoansController {

    private IServiceLoans serviceLoans;

    @GetMapping(path = "/fetch")
    public ResponseEntity<LoansDto> fetchLoans(@RequestParam String mobileNumber){

        return ResponseEntity.status(HttpStatus.OK).body(serviceLoans.fetchLoan(mobileNumber));
    }
}
