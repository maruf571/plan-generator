package com.lendico.plangenerator.service;

import java.math.BigDecimal;

public interface PlanGeneratorFormula {

    BigDecimal calculateInterest(BigDecimal interestRate,
                                 Integer daysInMonth,
                                 BigDecimal outstandingPrincipal,
                                 Integer daysInYear);

    BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest);

    BigDecimal calculateBorrowerPayment(BigDecimal principal, BigDecimal interest);

    BigDecimal calculateAnnuity(BigDecimal interestRate, Integer period, BigDecimal presentValue);
}
