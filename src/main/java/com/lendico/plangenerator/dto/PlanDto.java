package com.lendico.plangenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder
@ToString
public class PlanDto {

    private BigDecimal borrowerPaymentAmount;

    private Date date;

    private BigDecimal initialOutstandingPrincipal;

    private BigDecimal interest;

    private BigDecimal principal;

    private BigDecimal remainingOutstandingPrincipal;
}
