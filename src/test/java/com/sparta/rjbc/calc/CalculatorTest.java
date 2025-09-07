package com.sparta.rjbc.calc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Addition Tests, adding two numbers returns correct sum")
    void add_TwoNumbers_ReturnsCorrectSum() {
        assertThat(calc.add(2.0, 3.0), is(5.0));
    }

    @Test
    @DisplayName("Adding a negative and a positive number ")
    void add_NegativeAndPositiveNumber_ReturnsCorrectSum() {
        assertThat(calc.add(-2.0, 3.0), is(1.0));
    }

    @Test
    @DisplayName("Adding two decimal numbers")
    void add_TwoDecimals_ReturnsCorrectSum() {
        assertThat(calc.add(2.5, 3.1), is(5.6));
    }

    @Test
    @DisplayName("Subtraction Tests, subtracting two numbers returns correct difference")
    void minus_TwoNumbers_ReturnsCorrectMinus() {
        assertThat(calc.minus(5.0, 3.0), is(2.0));
    }

    @Test
    @DisplayName("Division Tests, dividing two numbers returns correct division")
    void divide_TwoNumbers_ReturnsCorrectDivision() {
        assertThat(calc.divide(6.0, 3.0), is(2.0));
    }

    @Test
    @DisplayName("Division by zero throws IllegalArgumentException")
    void divide_ByZero_ThrowsException() {
        try {
            calc.divide(5.0, 0.0);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Cannot divide by zero"));
        }
    }

    @Test
    @DisplayName("Multiplication Tests, multiplying two numbers returns correct multiplication")
    void multiply_TwoNumbers_ReturnsCorrectMultiplication() {
        assertThat(calc.multiply(2.0, 3.0), is(6.0));
    }
}