package com.sparta.rjbc.calc;

public class Calculator {

    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double minus(Double a, Double b) {
        return a - b;
    }

    public Double divide(Double a, Double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

}