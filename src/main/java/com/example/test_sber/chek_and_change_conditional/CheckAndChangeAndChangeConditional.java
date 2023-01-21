package com.example.test_sber.chek_and_change_conditional;

import com.example.test_sber.dto.AccountDto;

public interface CheckAndChangeAndChangeConditional {

    void checkConditional(AccountDto accountDto);
    void changeConditional(AccountDto accountDto, String tr);
}
