package com.lendico.plangenerator.service;

import com.lendico.plangenerator.dto.PlanWrapper;
import com.lendico.plangenerator.dto.RepaymentDto;

public interface GeneratePlanService {
    PlanWrapper generatePlan(RepaymentDto repaymentDto);
}
