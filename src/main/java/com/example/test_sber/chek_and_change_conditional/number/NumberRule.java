package com.example.test_sber.chek_and_change_conditional.number;

public  class NumberRule {
    private final String start;
    private final String tailReplacement;

    public NumberRule(String start, String tailReplacement) {
        this.start = start;
        this.tailReplacement = tailReplacement;
    }

    public String getStart() {
        return start;
    }

    public String getTailReplacement() {
        return tailReplacement;
    }
}
