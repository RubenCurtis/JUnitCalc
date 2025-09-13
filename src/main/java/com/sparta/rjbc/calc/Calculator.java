package com.sparta.rjbc.calc;

public class Calculator {

    public Double add(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return a + b;
    }

    public Double minus(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Cannot have a null argument");
        }
        return a - b;
    }

    public Double divide(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Cannot have a null argument");
        }
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public Double multiply(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Cannot have a null argument");
        }
        return a * b;
    }

}