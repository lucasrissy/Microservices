package com.section.Accounts.mapper;

import com.section.Accounts.dto.AccountsDto;
import com.section.Accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto dto){

        dto.setAccountType(accounts.getAccountType());
        dto.setBranchAddress(accounts.getBranchAddress());

        return dto;
    }

    public static Accounts mapToEntity(Accounts accounts, AccountsDto dto){
        accounts.setAccountNumber(accounts.getAccountNumber());
        accounts.setAccountType(accounts.getAccountType());
        accounts.setBranchAddress(accounts.getBranchAddress());

        return accounts;
    }
}
