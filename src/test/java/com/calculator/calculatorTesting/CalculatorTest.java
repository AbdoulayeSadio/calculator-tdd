package com.calculator.calculatorTesting;

import com.calculator.calculator.Calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;



import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;



public class CalculatorTest {

    private Calculator calculatorUnderTest;
    private static Instant startedAt;

    @BeforeEach
    public void initCalculator(){
        System.out.println("Appelé avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator(){
        System.out.println("Appelé après chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void  initStartingTime(){
        System.out.println("Appelé avant tous test");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration(){
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    public void add_shouldReturnTheSum_ofTwoPositiveInteger(){
        //Arrange
        int a = 2;
        int b = 3;
        //Act
        int somme = calculatorUnderTest.add(a, b);
        //Assert
        assertThat(somme).isEqualTo(5);
    }

    @Test
    public void add_shouldReturnTheSum_ofTwoPositiveDouble(){
        //Arrange
        double a = 2.3;
        double b = 3.4;
        //Act
        double somme = calculatorUnderTest.add(a, b);
        //Assert

    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoPositiveInteger(){

        //Arrange
        int a = 5;
        int b = 7;
        //Act
        int produitOfAandB = calculatorUnderTest.multiply(a,b);
        //Assert
        assertThat(produitOfAandB).isEqualTo(35);
    }

    @ParameterizedTest(name = "{0}x0 doit être égal à 0")
    @ValueSource(ints = {23,12,57,789})
    public void multiply_shouldReturnZero_ofZeroWtihMultiplesIntegers(int arg){

        //Arrange
        //Act
        int actualResult = calculatorUnderTest.multiply(arg,0);
        //Assert
        assertThat(actualResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({"2,4,6", "5,7,12", "13,12,25", "123, 123, 246"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectedResult){
        //Arrange
        //Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);
        //Assert
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Timeout(1)
    @Test
    public void longCalcul_shouldComputeInLessThan1Second() throws InterruptedException {
        // Arrange

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        // ...
    }

    @Test
    public  void digitSet_shouldReturnTheSetOfDigits_ofPositiveInteger(){
        //GIVEN
        int number = 2543;
        //WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitSet(number);
        //THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(2,5,4,3);
    }
}
