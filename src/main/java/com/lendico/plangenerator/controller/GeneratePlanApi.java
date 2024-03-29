package com.lendico.plangenerator.controller;

import com.lendico.plangenerator.dto.PlanWrapper;
import com.lendico.plangenerator.dto.RepaymentDto;
import com.lendico.plangenerator.service.GeneratePlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GeneratePlanApi.GENERATE_PLAN_API)
public class GeneratePlanApi {

    public static final String GENERATE_PLAN_API =  "/generate-plan";
    private final GeneratePlanService generatePlanService;

    @PostMapping
    public ResponseEntity<PlanWrapper> generatePlanDto(@RequestBody @Valid final RepaymentDto repaymentDto){
        return ResponseEntity.ok(generatePlanService.generatePlan(repaymentDto));
    }
}
