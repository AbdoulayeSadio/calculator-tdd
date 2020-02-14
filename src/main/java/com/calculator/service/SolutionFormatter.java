package com.calculator.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public interface SolutionFormatter {

    String format(int solution);
}
