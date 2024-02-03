package com.lendico.plangenerator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class PlanGeneratorFormula {

    private static final int SCALE_FOR_SMALL_NUMBER = 10;
    private static final int SCALE_FOR_BIG_NUMBER = 2;
    /**
     * Interest calculation interest = (interestRate * daysInMonth * outstandingPrincipal) / daysInYear
     *
     * @param interestRate interest rate yearly
     * @param daysInMonth for this project 30
     * @param outstandingPrincipal remaining loan
     * @param daysInYear for this project 360
     * @return interest
     */

    public BigDecimal calculateInterest(final BigDecimal interestRate,
                                        final Integer daysInMonth,
                                        final BigDecimal outstandingPrincipal,
                                        final Integer daysInYear) {
        return interestRate.divide(BigDecimal.valueOf(100), SCALE_FOR_SMALL_NUMBER, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(daysInMonth))
                .multiply(outstandingPrincipal)
                .divide(BigDecimal.valueOf(daysInYear), SCALE_FOR_BIG_NUMBER, RoundingMode.HALF_EVEN);
    }

    /**
     * Principal calculation, principal = Annuity - Interest
     * @param annuity current loan
     * @param interest calculated interest
     * @return principal
     */

    public BigDecimal calculatePrincipal(BigDecimal annuity, BigDecimal interest) {
        return annuity.subtract(interest);
    }

    /**
     * Borrower Payment Amount(Annuity) = Principal + Interest
     */

    public BigDecimal calculateBorrowerPayment(BigDecimal principal, BigDecimal interest) {
        return principal.add(interest);
    }

    /**
     * For equation, please look into the following link
     * https://financeformulas.net/Annuity_Payment_Formula.html
     *
     * @param interestRate Interest rate yearly
     * @param period Number of month
     * @param presentValue value of the current loan
     * @return annuity
     */

    public BigDecimal calculateAnnuity(BigDecimal interestRate, Integer period, BigDecimal presentValue) {
        // Monthly rate = yearly rate / (100 * 12)
        BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(1200), SCALE_FOR_SMALL_NUMBER, RoundingMode.HALF_EVEN);
        return monthlyRate.multiply(presentValue).divide(
                BigDecimal.ONE.subtract(
                        BigDecimal.ONE.add(monthlyRate).pow(-period, new MathContext(SCALE_FOR_SMALL_NUMBER))
                ),
                SCALE_FOR_BIG_NUMBER, RoundingMode.HALF_EVEN
        );
    }
}
