package com.calculator.service;

import jdk.jfr.Name;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SolutionFormatterImpl implements SolutionFormatter {
    @Override
    public String format(int solution) {
        return String.format(Locale.FRENCH, "%,d", solution);
    }

}
