package com.example.test_sber.service;

import com.example.test_sber.chek_and_change_conditional.number.NumberCheckAndChangeConditional;
import com.example.test_sber.chek_and_change_conditional.subdivision.SubDivisionCheckAndChangeConditional;
import com.example.test_sber.dto.AccountDto;
import com.example.test_sber.mapper.AccountMapper;
import com.example.test_sber.repositiry.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {AccountServiceImpl.class, NumberCheckAndChangeConditional.class, SubDivisionCheckAndChangeConditional.class})
class AccountServiceImplTest {
    @Autowired
    AccountServiceImpl accountService;
    @MockBean
    AccountRepository accountRepository;
    @MockBean
    AccountMapper accountMapper;


    @Test
    @DisplayName("Number_StartWith_101")
    public void number_check_and_change_conditional_101_test() {
        AccountDto accountDto = new AccountDto("10145678901234567890", "123456");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("10145678901200000000", accountDto.getNumber());
    }

    @Test
    @DisplayName("Number_StartWith_202")
    void number_check_and_change_conditional_202_test() {
        AccountDto accountDto = new AccountDto("20245678901234567891", "123456");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("20245678901234567800", accountDto.getNumber());
    }

    @DisplayName("Number_StartWith_any")
    @Test
    void number_check_and_change_conditional_any_test(){
        AccountDto accountDto = new AccountDto("12345678901234567890", "123456");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("12345678901234567890", accountDto.getNumber());
    }

    @DisplayName("Number_StartWith_4")
    @Test
    void number_check_and_change_conditional_4_test(){
        AccountDto accountDto = new AccountDto("42345678901234567890", "123456");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("42345678941234567890", accountDto.getNumber());
    }

    @DisplayName("SubDivision_StartWith_99")
    @Test
    void subDivision_check_and_change_conditional_99_test(){
        AccountDto accountDto = new AccountDto("01234567890123456789", "993456");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("0000", accountDto.getSubdivision());
    }

    @DisplayName("SubDivision_Big_Length")
    @Test
    void subDivision_check_and_change_conditional_length_test(){
        AccountDto accountDto = new AccountDto("01234567890123456789", "1234567890");

        accountService.changeConditional(accountDto);

        Assertions.assertEquals("123456", accountDto.getSubdivision());
    }
}