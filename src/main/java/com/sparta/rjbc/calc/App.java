package com.sparta.rjbc.calc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the calculator");

        System.out.print("Enter first number: ");
        Double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        Double num2 = scanner.nextDouble();

        System.out.println("Select operation: +, -, *, /");
        System.out.println(" + : Addition");
        System.out.println(" - : Subtraction");
        System.out.println(" * : Multiplication");
        System.out.println(" / : Division");

        String choice = scanner.next();

        switch (choice) {
            case "+":
                System.out.println("Result: " + calculator.add(num1, num2));
                break;
            case "-":
                System.out.println("Result: " + calculator.minus(num1, num2));
                break;
            case "*":
                System.out.println("Result: " + calculator.multiply(num1, num2));
                break;
            case "/":
                try {
                    System.out.println("Result: " + calculator.divide(num1, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation selected.");

        }
    }
    
}
