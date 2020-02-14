package com.calculator.calculator;


import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public int fact(int a) {
        if (a < 0 || a > 12) {
            throw new IllegalArgumentException("Doit être compris entre 0 et 12.");
        }
        if (a <= 1) {
            return a;
        }
        return a*fact(a-1);
    }

    public void longCalculation() throws InterruptedException {
        Thread.sleep(500);
    }

    public Set<Integer> digitSet(int number) {
        Set<Integer> tab = new HashSet<>();

        String str = number+"";

        for (int i = 0; i < str.length(); i++){
            tab.add(Integer.parseInt(str.charAt(i)+""));
        }
        return tab;
    }

}
