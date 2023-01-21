package com.example.test_sber.chek_and_change_conditional.number;

import com.example.test_sber.chek_and_change_conditional.CheckAndChangeAndChangeConditional;
import com.example.test_sber.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberCheckAndChangeConditional implements CheckAndChangeAndChangeConditional {

    private static final List<NumberRule> advancedRules = new ArrayList<>();


    static {
        advancedRules.add(new NumberRule("101", "00000000"));
        advancedRules.add(new NumberRule("202", "00"));
        advancedRules.add(new NumberRule("3", "4"));
        advancedRules.add(new NumberRule("4", "4"));
    }


    @Override
    public void checkConditional(AccountDto accountDto) {

        advancedRules.stream()
                .filter(rule -> accountDto.getNumber().startsWith(rule.getStart()))
                .forEach(numberRule -> changeConditional(accountDto, numberRule.getTailReplacement()));
    }



    @Override
    public void changeConditional(AccountDto accountDto, String tailReplacement) {

        if (tailReplacement.equals("3") || tailReplacement.equals("4")){
            String updateNumber = accountDto.getNumber().substring(0,9) + tailReplacement + accountDto.getNumber().substring(10,20);
            accountDto.setNumber(updateNumber);
        }else {
            int length = 20 - tailReplacement.length();
            String updatedNumber = accountDto.getNumber().substring(0, length) + tailReplacement;
            accountDto.setNumber(updatedNumber);
        }
    }
}
