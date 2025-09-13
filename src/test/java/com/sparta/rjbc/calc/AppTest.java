package com.sparta.rjbc.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Given a valid addition, output the correct answer")
    void test_Addition() {
        String input = "5\n3\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 8.0"));
    }

    @Test
    @DisplayName("Given an incorrect input, handle it correctly and then complete addition given a valid input")
    void test_Invalid_Number_Input() {
        String input = "abc\n5\n2\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, allOf(
                containsString("Invalid input. Please enter a valid number."),
                containsString("Result: 7.0")
        ));
    }

    @Test
    @DisplayName("Given division by zero, handle it, then complete addition task when prompted")
    void test_Division_By_Zero() {
        String input = "10\n0\n/\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, allOf(
                containsString("Cannot divide by zero"),
                containsString("Result: 10.0")
        ));
    }

    @Test
    @DisplayName("Given a negative number to add, handle the logic and return correct values")
    void add_Negative_Numbers() {
        String input = "-50\n5\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: -45.0"));
    }

    @Test
    @DisplayName("Given multiple negative numbers to add, handle the logic and return correct values")
    void add_Multiple_Negative_Numbers() {
        String input = "-5\n-10\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: -15.0"));
    }

    @Test
    @DisplayName("Given a valid subtraction, output the correct answer")
    void test_Subtraction() {
        String input = "10\n4\n-\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 6.0"));
    }

    @Test
    @DisplayName("Given a valid multiplication, output the correct answer")
    void test_Multiplication() {
        String input = "7\n6\n*\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 42.0"));
    }

    @Test
    @DisplayName("Given a valid division, output the correct answer")
    void test_Division() {
        String input = "20\n5\n/\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 4.0"));
    }

    @Test
    @DisplayName("Given multiple invalid inputs, handle them and then complete a valid operation")
    void test_Multiple_Invalid_Inputs() {
        String input = "abc\nxyz\n10\n2\n*\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, allOf(
                containsString("Invalid input. Please enter a valid number."),
                containsString("Result: 20.0")
        ));
    }

    @Test
    @DisplayName("Given a floating point input, correctly calculate addition")
    void test_Floating_Point_Addition() {
        String input = "3.5\n2.5\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 6.0"));
    }

    @Test
    @DisplayName("Given a floating point input, correctly calculate subtraction")
    void test_Floating_Point_Subtraction() {
        String input = "5.5\n2.0\n-\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 3.5"));
    }

    @Test
    @DisplayName("Given a floating point input, correctly calculate multiplication")
    void test_Floating_Point_Multiplication() {
        String input = "2.5\n4.0\n*\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 10.0"));
    }

    @Test
    @DisplayName("Given a floating point input, correctly calculate division")
    void test_Floating_Point_Division() {
        String input = "7.5\n2.5\n/\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, containsString("Result: 3.0"));
    }

    @Test
    @DisplayName("Given an invalid operator, prompt and handle valid operator afterwards")
    void test_Invalid_Operator_Handling() {
        String input = "5\n5\n^\n+\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App.main(new String[]{});

        String output = outputStream.toString();
        assertThat(output, allOf(
                containsString("Invalid operation selected. Please try again."),
                containsString("Result: 10.0")
        ));
    }
}
