package com.lendico.plangenerator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PlanGeneratorFormulaImplTest {

    private static PlanGeneratorFormula formula;

    @BeforeAll
    public static void init() {
        formula = new PlanGeneratorFormulaImpl();
    }

    @Test
    public void test_interest_calculation() {

        BigDecimal interest = formula.calculateInterest(
                BigDecimal.valueOf(5),
                30,
                BigDecimal.valueOf(5000),
                360
        );
        Assertions.assertEquals(BigDecimal.valueOf(20.83), interest);
    }

    @Test
    public void test_calculate_principal() {
        BigDecimal principal = formula.calculatePrincipal(BigDecimal.valueOf(219.36), BigDecimal.valueOf(20.83));
        Assertions.assertEquals(BigDecimal.valueOf(198.53), principal);
    }

    @Test
    public void test_calculate_borrower_payment() {
        BigDecimal bp = formula.calculateBorrowerPayment(BigDecimal.valueOf(198.53), BigDecimal.valueOf(20.83));
        Assertions.assertEquals(BigDecimal.valueOf(219.36), bp);
    }

    @Test
    public void test_calculate_annuity() {
        BigDecimal annuity = formula.calculateAnnuity(BigDecimal.valueOf(5), 24, BigDecimal.valueOf(5000));
        Assertions.assertEquals(BigDecimal.valueOf(219.36), annuity);
    }
}
