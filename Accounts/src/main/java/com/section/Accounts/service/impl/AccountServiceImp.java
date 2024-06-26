package com.section.Accounts.service.impl;

import com.section.Accounts.constant.AccountConstants;
import com.section.Accounts.dto.AccountsDto;
import com.section.Accounts.dto.CustomerDto;
import com.section.Accounts.entity.Accounts;
import com.section.Accounts.entity.Customer;
import com.section.Accounts.exception.CustomerAlreadyExistException;
import com.section.Accounts.exception.ResourceNotFound;
import com.section.Accounts.mapper.AccountsMapper;
import com.section.Accounts.mapper.CustomerMapper;
import com.section.Accounts.repository.AccountsRepository;
import com.section.Accounts.repository.CustomerRepository;
import com.section.Accounts.service.AccountServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImp implements AccountServiceInterface {


    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.maoToEntity(new Customer(),customerDto);

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());

        if (optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number");
        }

        Customer savedCustomer = customerRepository.save(customer);

        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(()-> new ResourceNotFound("Customer","mobileNumber",mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFound("Account","CustomerID", customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(new CustomerDto(),customer);
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFound("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToEntity(accounts, accountsDto);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFound("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.maoToEntity(customer,customerDto);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFound("Customer", "mobileNumber", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    private Accounts createNewAccount(Customer customer){

        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long randomNumber = 10000000L + new Random().nextInt(900000);

        accounts.setAccountNumber(randomNumber);
        accounts.setAccountType(AccountConstants.SAVINGS);
        accounts.setBranchAddress(AccountConstants.ADDRESS);

        return accounts;
    }
}
