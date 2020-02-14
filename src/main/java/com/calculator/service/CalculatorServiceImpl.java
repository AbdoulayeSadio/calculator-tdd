package com.calculator.service;

import com.calculator.calculator.Calculator;
import com.calculator.calculator.model.CalculationModel;
import com.calculator.calculator.model.CalculationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import javax.inject.Named;

@Service
@Component
public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    private SolutionFormatter solutionFormatter;

    @Autowired
    public CalculatorServiceImpl(Calculator calculator, SolutionFormatter solutionFormatter) {
        this.calculator = calculator;
        this.solutionFormatter = solutionFormatter;
    }

    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = null;
        switch (type) {
            case ADDITION:
                response = calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
                break;
            case SUBTRACTION:
                response = calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
                break;
            case MULTIPLICATION:
                response = calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
                break;
            case DIVISION:
                response = calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
                break;
            default:
                throw new UnsupportedOperationException("Unsupported calculations");
        }

        calculationModel.setSolution(response);
        calculationModel.setFormattedSolution(solutionFormatter.format(response));
        return calculationModel;
    }
}
