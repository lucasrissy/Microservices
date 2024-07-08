package com.example.Loans.repository;

import com.example.Loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepository extends JpaRepository<Loans,Long> {

    boolean findByMobileNumber(String mobileNumber);
}
