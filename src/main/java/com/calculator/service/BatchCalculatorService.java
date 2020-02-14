package com.calculator.service;

import com.calculator.calculator.model.CalculationModel;

import java.util.List;
import java.util.stream.Stream;

public interface BatchCalculatorService {
    public List<CalculationModel> batchCalculate(Stream<String> operations);
}
