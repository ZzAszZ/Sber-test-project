package com.example.test_sber.mapper;

import com.example.test_sber.dto.AccountDto;
import com.example.test_sber.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account dtoToEntity(AccountDto accountDto){

        Account account = new Account();

        account.setNumber(accountDto.getNumber());
        account.setSubdivision(accountDto.getSubdivision());

        return  account;
    }
}
