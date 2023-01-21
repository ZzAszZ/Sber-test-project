package com.example.test_sber.controllers.restcontrolles;


import com.example.test_sber.dto.AccountDto;
import com.example.test_sber.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/accounts")
    public ResponseEntity<?> addAccount(@RequestBody @Valid AccountDto accountDto){
        accountService.save(accountDto);
        return new ResponseEntity<>("Account registered", HttpStatus.ACCEPTED);
    }
}
