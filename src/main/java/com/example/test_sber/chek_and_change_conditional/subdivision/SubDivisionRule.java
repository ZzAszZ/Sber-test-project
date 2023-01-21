package com.example.test_sber.chek_and_change_conditional.subdivision;

public class SubDivisionRule {
    private final String start;
    private final String tailReplacement;
    private final Integer length;

    public SubDivisionRule(String start, String tailReplacement, Integer length) {
        this.start = start;
        this.tailReplacement = tailReplacement;
        this.length = length;
    }

    public int getLength() {return length;}

    public String getStart() {
        return start;
    }

    public String getTailReplacement() {
        return tailReplacement;
    }
}

