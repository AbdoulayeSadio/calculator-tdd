package com.calculator.serviceTesting;

import com.calculator.calculator.Calculator;
import com.calculator.calculator.model.CalculationModel;
import com.calculator.calculator.model.CalculationType;
import com.calculator.service.CalculatorService;
import com.calculator.service.CalculatorServiceImpl;
import com.calculator.service.SolutionFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    Calculator calculator;

    @Mock
    SolutionFormatter solutionFormatter;
    // Calculator IS CALLED BY CalculatorService
    CalculatorService classUnderTest;

    @BeforeEach
    public void init(){
        classUnderTest = new CalculatorServiceImpl(calculator, solutionFormatter);
    }
    @Test
    public void calculate_shouldUseCalculator_forAddition() {
        // GIVEN
        when(calculator.add(1, 2)).thenReturn(3);

        // WHEN
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

        // THEN
        verify(calculator).add(1, 2);
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void add_returnsTheSum_ofTwoNegativeNumbers() {
        // GIVEN
        when(calculator.add(-1, 2)).thenReturn(1);
        //WHEN
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, -1, 2))
                .getSolution();
        //THEN
        verify(calculator).add(-1, 2);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void add_returnsTheSum_ofZeroAndZero() {
        //GIVEN
        when(calculator.add(0,0)).thenReturn(0);
        //WHEN
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, 0, 0)).getSolution();
        //TEHN
        verify(calculator).add(0,0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculate_shouldFormatSolution_forAnAddition() {
        //GIVEN
        when(calculator.add(10000, 3000)).thenReturn(13000);
        when(solutionFormatter.format(13000)).thenReturn("13 000");
        //WHEN
        final String formattedResultat = classUnderTest
                .calculate(new CalculationModel(CalculationType.ADDITION, 10000, 3000))
                .getFormattedSolution();
        assertThat(formattedResultat).isEqualTo("13 000");
    }
}
