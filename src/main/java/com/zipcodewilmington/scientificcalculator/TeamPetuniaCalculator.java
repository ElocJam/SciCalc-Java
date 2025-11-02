package com.zipcodewilmington.scientificcalculator;

/**
 * Created by leon on 2/9/18.
 */
public class TeamPetuniaCalculator {
    
    public static boolean checkForClear(String input) {
        if (input.equals("clear")) {
            Console.println("Cleared");
            return true;
        }
        return false;
    }

    public static boolean checkForQuit(String input) {
        if (input.equals("quit")) {
            Console.println("Goodbye!");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Console.println("Welcome to Team Petunia's Calculator!");
        Double display = 0.0;
        Boolean running = true;
        Boolean errorState = false;

        while (running) {
            Console.println("Current display: %.2f", display);

                if (errorState) {
                    String clearInput = Console.getStringInput("Error, please clear before continuing");
                    if (checkForQuit(clearInput)) break;
                    if (checkForClear(clearInput)) {
                        display = 0.0;
                        errorState = false;
                    }
                    continue;
                }

            String firstInput = Console.getStringInput("Please enter first number");
            if (checkForQuit(firstInput)) break;
            if (checkForClear(firstInput)) {
                display = 0.0;
                continue;
            }
            Double firstNumber;
            if (firstInput.trim().isEmpty()) {
                firstNumber = display;
                Console.println("Using display value: %.2f", firstNumber);
            } else {
                firstNumber = Double.parseDouble(firstInput);
            }

            String operation = Console.getStringInput("Please enter operator");
            if (checkForQuit(operation)) break;
            if (checkForClear(operation)) {
                display = 0.0;
                continue;
            }

            String secondInput = Console.getStringInput("Please enter second number");
            if (checkForQuit(secondInput)) break;
            if (checkForClear(secondInput)) {
                display = 0.0;
                continue;
            }
            Double secondNumber = Double.parseDouble(secondInput);
        
        //TEST CODE
        Double result = null;

        if (operation.equals("+")) {
            result = firstNumber + secondNumber; //Devesh function
        } else if (operation.equals("-")) {
            result = firstNumber - secondNumber; //Devesh function
        } else if (operation.equals("*")) {
            result = firstNumber * secondNumber; //Devesh function
        } else if (operation.equals("/")) {
            result = firstNumber / secondNumber; //Devesh function
        } else {
            Console.println("ERR");
            errorState = true;
        }
        if (result != null) {
            display = result;
            Console.println("Result: %.2f", result);
        }
        //END OF TEST CODE
        }
    }
}
   
