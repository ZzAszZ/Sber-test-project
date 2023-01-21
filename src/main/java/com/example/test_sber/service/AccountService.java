package com.example.test_sber.service;

import com.example.test_sber.dto.AccountDto;

public interface AccountService {
    void save(AccountDto accountDto);

    void changeConditional(AccountDto accountDto);
}
