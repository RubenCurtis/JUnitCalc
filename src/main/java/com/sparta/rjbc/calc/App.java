package com.sparta.rjbc.calc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the calculator");
        System.out.println("You can add, subtract, multiply or divide");
        System.out.println("Enter 'e' at any time to exit.");

        while (true) {
            Double num1 = scanForDouble(scanner, "Enter first number: ");
            if (num1 == null) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            Double num2 = scanForDouble(scanner, "Enter second number: ");
            if (num2 == null) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            boolean validOperation = false;
            while (!validOperation) {
                System.out.println("Select operation: +, -, *, /");
                System.out.println("or 'e' to exit: ");
                if (!scanner.hasNext()) {
                    System.out.println("No input detected. Exiting calculator.");
                    return;
                }
                String choice = scanner.next();

                if ("e".equalsIgnoreCase(choice)) {
                    System.out.println("Exiting calculator. Goodbye!");
                    return;
                }

                switch (choice) {
                    case "+":
                        System.out.println("Result: " + calculator.add(num1, num2));
                        validOperation = true;
                        break;
                    case "-":
                        System.out.println("Result: " + calculator.minus(num1, num2));
                        validOperation = true;
                        break;
                    case "*":
                        System.out.println("Result: " + calculator.multiply(num1, num2));
                        validOperation = true;
                        break;
                    case "/":
                        try {
                            System.out.println("Result: " + calculator.divide(num1, num2));
                            validOperation = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid operation selected. Please try again.");
                }
            }
        }
    }

    private static Double scanForDouble(Scanner scanner, String message) {
        Double number = null;
        while (number == null) {
            System.out.print(message);
            if (!scanner.hasNext()) {
                return null;
            }
            String input = scanner.next();
            if ("e".equalsIgnoreCase(input)) {
                return null;
            }
            try {
                number = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return number;
    }
}