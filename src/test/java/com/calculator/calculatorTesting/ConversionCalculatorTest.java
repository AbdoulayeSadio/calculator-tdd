package com.calculator.calculatorTesting;

import com.calculator.calculator.ConversionCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

@Tag("ConversionTests")
@DisplayName("Réussir à convertir entre différentes unités.")
public class ConversionCalculatorTest {
    private ConversionCalculator calculatorUnderTest = new ConversionCalculator();

    @Nested // (3)
    @Tag("TemperatureTests") // (4)
    @DisplayName("Réussir à convertir des températures") // (4)
    class TemperatureTests {
        @Test
        @DisplayName("Soit une T° à 0°C, lorsque l'on convertit en °F, alors on obtient 32°F.")
        public void celsiusToFahrenheit_returnsAFahrenheitTempurature_whenCelsiusIsZero() {
            Double actualFahrenheit = calculatorUnderTest.celsiusToFahrenheit(0.0);
           assertThat(actualFahrenheit).isCloseTo(32.0, withinPercentage(0.01));
        }

        @Test
        @DisplayName("Soit une T° à 32°F, lorsque l'on convertit en °C, alors on obtient 0°C.")
        public void fahrenheitToCelsius_returnsZeroCelciusTempurature_whenThirtyTwo() {
            Double actualCelsius = calculatorUnderTest.fahrenheitToCelsius(32.0);
            assertThat(actualCelsius).isCloseTo(0.0, withinPercentage(0.01));
        }
    }
}
