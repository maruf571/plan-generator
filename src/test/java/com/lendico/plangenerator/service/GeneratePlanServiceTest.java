package com.lendico.plangenerator.service;

import com.lendico.plangenerator.dto.PlanWrapper;
import com.lendico.plangenerator.dto.RepaymentDto;
import com.lendico.plangenerator.exception.PlanGeneratorException;
import com.lendico.plangenerator.validation.RepaymentValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;

class GeneratePlanServiceTest {

    private static GeneratePlanService generatePlanService;

    @BeforeAll
    public static void init() {
        PlanGeneratorFormula formula = new PlanGeneratorFormula();
        RepaymentValidator validator = new RepaymentValidator();
        generatePlanService = new GeneratePlanService(formula, validator);
    }

    @Test
    void test_generate_plan() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 1);

        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setDuration(24);
        repaymentDto.setLoanAmount(BigDecimal.valueOf(5000));
        repaymentDto.setNominalRate(BigDecimal.valueOf(5.00));
        repaymentDto.setStartDate(calendar.getTime());

        PlanWrapper planWrapper = generatePlanService.generatePlan(repaymentDto);

        Assertions.assertEquals(24, planWrapper.getPlanDtoList().size());

        Assertions.assertEquals(BigDecimal.valueOf(
                219.36),
                planWrapper.getPlanDtoList().get(0).getBorrowerPaymentAmount()
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(198.53),
                planWrapper.getPlanDtoList().get(0).getPrincipal()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(20.83),
                planWrapper.getPlanDtoList().get(0).getInterest()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(5000),
                planWrapper.getPlanDtoList().get(0).getInitialOutstandingPrincipal()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(4801.47),
                planWrapper.getPlanDtoList().get(0).getRemainingOutstandingPrincipal()
        );


        Assertions.assertEquals(BigDecimal.valueOf(
                219.36),
                planWrapper.getPlanDtoList().get(1).getBorrowerPaymentAmount()
        );

        Assertions.assertEquals(
                BigDecimal.valueOf(199.35),
                planWrapper.getPlanDtoList().get(1).getPrincipal()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(20.01),
                planWrapper.getPlanDtoList().get(1).getInterest()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(4801.47),
                planWrapper.getPlanDtoList().get(1).getInitialOutstandingPrincipal()
        );


        Assertions.assertEquals(
                BigDecimal.valueOf(4602.12),
                planWrapper.getPlanDtoList().get(1).getRemainingOutstandingPrincipal()
        );
    }

    @Test
    void test_generate_plan_loan_amount_exception() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 1);

        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setDuration(24);
        repaymentDto.setLoanAmount(BigDecimal.valueOf(0));
        repaymentDto.setNominalRate(BigDecimal.valueOf(5.00));
        repaymentDto.setStartDate(calendar.getTime());

        Exception exception = Assertions.assertThrows(PlanGeneratorException.class, () -> generatePlanService.generatePlan(repaymentDto));
        Assertions.assertEquals("Loan amount can not be negative", exception.getMessage());
    }

    @Test
    void test_generate_plan_duration_exception() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.JANUARY, 1);

        RepaymentDto repaymentDto = new RepaymentDto();
        repaymentDto.setDuration(0);
        repaymentDto.setLoanAmount(BigDecimal.valueOf(24));
        repaymentDto.setNominalRate(BigDecimal.valueOf(5.00));
        repaymentDto.setStartDate(calendar.getTime());

        Exception exception = Assertions.assertThrows(PlanGeneratorException.class, () -> generatePlanService.generatePlan(repaymentDto));
        Assertions.assertEquals("Duration can not be negative", exception.getMessage());
    }
}
