package com.example.test_sber.service;

import com.example.test_sber.chek_and_change_conditional.CheckAndChangeAndChangeConditional;
import com.example.test_sber.dto.AccountDto;
import com.example.test_sber.mapper.AccountMapper;
import com.example.test_sber.repositiry.AccountRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final List<CheckAndChangeAndChangeConditional> conditionals;


    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountMapper accountMapper,
                              List<CheckAndChangeAndChangeConditional> conditionals) {

        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.conditionals = conditionals;
    }


    public void save(AccountDto accountDto) {
        changeConditional(accountDto);
        accountRepository.save(accountMapper.dtoToEntity(accountDto));

    }

    public  void changeConditional(AccountDto accountDto) {
        conditionals
                .forEach(x -> x.checkConditional(accountDto));

    }
}
