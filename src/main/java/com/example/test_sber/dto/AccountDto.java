package com.example.test_sber.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountDto {

    public AccountDto(String number, String subdivision) {
        this.number = number;
        this.subdivision = subdivision;
    }


    @Size(min = 20, max = 20)
    @NotNull
    String number;
    @Size(min = 2, max = 20)
    @NotNull
    String subdivision;


    public String getNumber() {return number;}
    public void setNumber(String number) {this.number = number;}
    public String getSubdivision() {return subdivision;}
    public void setSubdivision(String subdivision) {this.subdivision = subdivision;}
}
