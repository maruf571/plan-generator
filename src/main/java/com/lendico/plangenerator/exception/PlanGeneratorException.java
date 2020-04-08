package com.lendico.plangenerator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PlanGeneratorException extends RuntimeException{

    private final String message;
}
