package com.lendico.plangenerator.validation;

import com.lendico.plangenerator.dto.RepaymentDto;
import com.lendico.plangenerator.exception.PlanGeneratorException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RepaymentValidator {

    public void validateLoanAmount(final RepaymentDto repaymentDto) {
        if(repaymentDto.getLoanAmount().compareTo(BigDecimal.ONE) < 0) {
            throw new PlanGeneratorException("Loan amount can not be negative");
        }
    }

    public void validateDuration(final RepaymentDto repaymentDto) {
        if(repaymentDto.getDuration() < 1) {
            throw new PlanGeneratorException("Duration can not be negative");
        }
    }
}
