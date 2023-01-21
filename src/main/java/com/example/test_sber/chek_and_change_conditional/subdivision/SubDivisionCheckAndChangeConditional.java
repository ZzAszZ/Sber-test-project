package com.example.test_sber.chek_and_change_conditional.subdivision;


import com.example.test_sber.chek_and_change_conditional.CheckAndChangeAndChangeConditional;
import com.example.test_sber.dto.AccountDto;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class SubDivisionCheckAndChangeConditional implements CheckAndChangeAndChangeConditional {
    private static final List<SubDivisionRule> advancedRules = new ArrayList<>();

    static {
        advancedRules.add(new SubDivisionRule("99", "0000", 6));
    }

    @Override
    public void checkConditional(AccountDto accountDto) {
        advancedRules.stream()
                .filter(rule -> accountDto.getSubdivision().startsWith(rule.getStart()))
                .forEach(subDivisionRule -> changeConditional(accountDto, subDivisionRule.getTailReplacement()));

       advancedRules.stream()
                .filter(rule -> accountDto.getSubdivision().length() > rule.getLength())
                .forEach(rule -> changeLength(accountDto, rule.getLength()));
    }

    @Override
    public void changeConditional(AccountDto accountDto, String tailReplacement) {
            accountDto.setSubdivision(tailReplacement);
    }

    public void changeLength(AccountDto accountDto, Integer length){
        String updateSubDivision = accountDto.getSubdivision().substring(0,length);
        accountDto.setSubdivision(updateSubDivision);
    }
}
