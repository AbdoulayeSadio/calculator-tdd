package com.calculator.calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a*b;
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

    public double add(double a, double b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}
