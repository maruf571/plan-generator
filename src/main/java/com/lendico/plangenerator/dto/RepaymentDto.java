package com.lendico.plangenerator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class RepaymentDto {

    @NotNull(message = "Loan amount is null")
    private BigDecimal loanAmount;

    @NotNull(message = "Nominal rate is null")
    private BigDecimal nominalRate;

    @NotNull(message = "Duration is null")
    private Integer duration;

    @NotNull(message = "Start date is null")
    private Date startDate;
}
