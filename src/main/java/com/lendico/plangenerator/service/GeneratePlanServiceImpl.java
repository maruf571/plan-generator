package com.lendico.plangenerator.service;

import com.lendico.plangenerator.dto.PlanDto;
import com.lendico.plangenerator.dto.PlanWrapper;
import com.lendico.plangenerator.dto.RepaymentDto;
import com.lendico.plangenerator.validation.RepaymentValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeneratePlanServiceImpl implements GeneratePlanService {
    private static final int DAYS_IN_A_MONTH = 30;
    private static final int DAYS_IN_A_YEAR = 360;

    private final PlanGeneratorFormula formula;
    private final RepaymentValidator validator;

    @Override
    public PlanWrapper generatePlan(final RepaymentDto repaymentDto) {
        // Validate input parameter
        validator.validateLoanAmount(repaymentDto);
        validator.validateDuration(repaymentDto);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(repaymentDto.getStartDate());

        List<PlanDto> planDtoList = new ArrayList<>();
        BigDecimal outstandingLoan = repaymentDto.getLoanAmount();
        int duration = repaymentDto.getDuration();

        for(int i=1; i<= repaymentDto.getDuration(); i++) {

            // Get Interest
            BigDecimal interest = formula.calculateInterest(repaymentDto.getNominalRate(),
                    DAYS_IN_A_MONTH,
                    outstandingLoan,
                    DAYS_IN_A_YEAR);

            // Get Annuity
            BigDecimal annuity = formula.calculateAnnuity( repaymentDto.getNominalRate(),
                    duration--,
                    outstandingLoan);

            // Get Principal
            BigDecimal principal = formula.calculatePrincipal(annuity, interest);
            if(principal.compareTo(outstandingLoan) > 0) {
                principal = outstandingLoan;
            }

            // Get borrower payment
            BigDecimal borrowPayment = formula.calculateBorrowerPayment(principal, interest);

            // Build plan dto
            PlanDto planDto = PlanDto.builder().date(calendar.getTime())
                    .interest(interest)
                    .principal(principal)
                    .borrowerPaymentAmount(borrowPayment)
                    .initialOutstandingPrincipal(outstandingLoan)
                    .remainingOutstandingPrincipal(outstandingLoan.subtract(principal))
                    .build();

            // Reduce the outstanding value
            outstandingLoan = outstandingLoan.subtract(principal);

            // Move to next date
            calendar.add(Calendar.MONTH, 1);

            planDtoList.add(planDto);
        }

        return new PlanWrapper(planDtoList);
    }
}
