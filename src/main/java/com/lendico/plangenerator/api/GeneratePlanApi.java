package com.lendico.plangenerator.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lendico.plangenerator.dto.PlanWrapper;
import com.lendico.plangenerator.dto.RepaymentDto;
import com.lendico.plangenerator.service.GeneratePlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GeneratePlanApi.GENERATE_PLAN_API)
public class GeneratePlanApi {

    public static final String GENERATE_PLAN_API =  "/generate-plan";
    private final GeneratePlanService generatePlanService;

    @PostMapping
    public ResponseEntity<PlanWrapper> generatePlanDto(@RequestBody @Valid final RepaymentDto repaymentDto) throws JsonProcessingException {
        return ResponseEntity.ok(generatePlanService.generatePlan(repaymentDto));
    }
}
