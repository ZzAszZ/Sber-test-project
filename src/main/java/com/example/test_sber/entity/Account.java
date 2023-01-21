package com.example.test_sber.entity;

import jakarta.persistence.*;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    private String subdivision;


    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
}
