package com.zipcodewilmington.scientificcalculator;

import java.util.Scanner;

/**
 * Created by leon on 2/9/18.
 */
public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        println(prompt);
        Integer userInput = scanner.nextInt();
        scanner.nextLine();
        return userInput;
    }

    public static Double getDoubleInput(String prompt) {
        println(prompt);
        Double userInput = scanner.nextDouble();
        scanner.nextLine();
        return userInput;
    }
}
