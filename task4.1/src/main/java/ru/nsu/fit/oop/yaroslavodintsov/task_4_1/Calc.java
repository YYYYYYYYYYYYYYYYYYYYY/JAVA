package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        Parser calculator = new Parser();

        Scanner input = new Scanner(System.in);
        String expression;

        while (input.hasNextLine()) {
            try {
                expression = input.nextLine();

                System.out.println(calculator.calculate(expression));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        input.close();
    }


}
