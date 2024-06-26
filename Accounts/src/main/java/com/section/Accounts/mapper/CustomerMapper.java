package com.section.Accounts.mapper;

import com.section.Accounts.dto.CustomerDto;
import com.section.Accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(CustomerDto dto, Customer customer){

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());

        return dto;
    }

    public static Customer maoToEntity(Customer entity, CustomerDto dto){

        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setMobileNumber(dto.getMobileNumber());

        return entity;
    }
}
