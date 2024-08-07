package com.example.Loans.repository;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoansRepository extends JpaRepository<Loans,Long> {

    Optional<Loans> findByMobileNumber(String mobileNumber);
}
