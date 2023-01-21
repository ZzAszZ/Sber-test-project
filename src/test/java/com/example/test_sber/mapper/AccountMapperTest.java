package com.example.test_sber.mapper;

import com.example.test_sber.dto.AccountDto;
import com.example.test_sber.entity.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest(classes = AccountMapper.class)
class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;


    @Test
    @DisplayName("Dto_to_Entity")
    void mapper_test(){
        AccountDto accountDto = new AccountDto("01234567890123456789","123456");
        Account account = accountMapper.dtoToEntity(accountDto);

                Assertions.assertEquals("01234567890123456789", account.getNumber());
                Assertions.assertEquals("123456",account.getSubdivision());
    }
}