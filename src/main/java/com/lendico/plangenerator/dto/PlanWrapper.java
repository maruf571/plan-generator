package com.lendico.plangenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class PlanWrapper {

    @JsonProperty("planList")
    private List<PlanDto> planDtoList;
}
