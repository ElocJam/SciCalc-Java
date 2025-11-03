package com.zipcodewilmington.scientificcalculator;
import java.util.Scanner;
public class MainApplication {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CalculatorEngine engine = new CalculatorEngine();
        Console.println("=== Welcome to the Scientific Calculator ===");
        Console.println("Type 'help' for commands, 'quit' to exit.");
        while (true) {
            Console.print("\nDisplay: %s\n", engine.getDisplay().getDisplayString());
            Console.print("Enter command or number: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                Console.println("Goodbye!");
                break;
            }
            if (input.equalsIgnoreCase("help")) {
                printHelp();
                continue;
            }
        
            if (isNumeric(input)) {
                double val = Double.parseDouble(input);
                engine.getDisplay().setDisplayValue(val);
                continue;
            }

            String[] parts = input.split("\\s+");
            String cmd = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : null;
            try {
                switch (cmd) {
                    case "+":
                    case "add":
                        engine.getArithmetic().add(getArgOrPrompt(arg, "Enter value to add: "));
                        break;
                    case "-":
                    case "subtract":
                    case "sub":
                        engine.getArithmetic().subtract(getArgOrPrompt(arg, "Enter value to subtract: "));
                        break;
                    case "*":
                    case "multiply":
                    case "mul":
                        engine.getArithmetic().multiply(getArgOrPrompt(arg, "Enter value to multiply: "));
                        break;
                    case "/":
                    case "divide":
                    case "div":
                        engine.getArithmetic().divide(getArgOrPrompt(arg, "Enter value to divide: "));
                        break;
                    case "square":
                        engine.getArithmetic().square();
                        break;
                    case "sqrt":
                    case "squareroot":
                        engine.getArithmetic().squareRoot();
                        break;
                    case "inverse":
                    case "1/x":
                        engine.getArithmetic().inverse();
                        break;
                    case "sign":
                    case "invertsign":
                    case "neg":
                        engine.getArithmetic().invertSign();
                        break;

                    case "sin":
                        engine.getTrig().sine();
                        break;
                    case "cos":
                        engine.getTrig().cosine();
                        break;
                    case "tan":
                        engine.getTrig().tangent();
                        break;
                    case "asin":
                        engine.getTrig().inverseSine();
                        break;
                    case "acos":
                        engine.getTrig().inverseCosine();
                        break;
                    case "atan":
                        engine.getTrig().inverseTangent();
                        break;
                    case "switchunits":
                    case "switchunit":
                        engine.getTrig().switchUnitsMode();
                        break;
                    case "setunits":
                        if (arg != null) engine.getTrig().switchUnitsMode(arg);
                        else Console.println("Usage: setunits degrees|radians");
                        break;

                    case "ln":
                        engine.getLogarithmic().ln();
                        break;
                    case "log":
                    case "log10":
                        engine.getLogarithmic().log();
                        break;
                    case "10^x":
                    case "tenpower":
                    case "10pow":
                        engine.getLogarithmic().tenPower();
                        break;
                    case "e^x":
                    case "exp":
                        engine.getLogarithmic().ePower();
                        break;

                    case "fact":
                    case "factorial":
                        engine.getFactorial().factorial();
                        break;

                    case "m+":
                    case "mplus":
                        engine.getMemory().addToMemory();
                        break;
                    case "mc":
                    case "memclear":
                        engine.getMemory().clearMemory();
                        break;
                    case "mrc":
                    case "mr":
                    case "recall":
                        engine.getMemory().recallMemory();
                        break;

                    case "switchdisplay":
                    case "switchmode":
                        engine.getDisplayMode().switchDisplayMode();
                        break;
                    case "setdisplay":
                    case "setmode":
                        if (arg != null) engine.getDisplayMode().switchDisplayMode(arg);
                        else Console.println("Usage: setmode decimal|binary|octal|hexadecimal");
                        break;
                    case "clear":
                        engine.getDisplay().clear();
                        break;
                    case "m2km":
                    case "milestokm":
                    case "milestokilo":
                         engine.getUnitConversion().milesToKilometers();
                        break;
                    case "km2m":
                    case "kmtomiles":
                    case "kilotomiles":
                        engine.getUnitConversion().kilometersToMiles();
                    break;
                    case "in2cm":
                        engine.getUnitConversion().inchesToCentimeters();
                    break;
                    case "cm2in":
                        engine.getUnitConversion().centimetersToInches();
                    break;
                    default:
                        Console.println("Unknown command. Type 'help' for a list of commands.");
                        break;

                }
            } catch (Exception e) {
                Console.println("Error: %s", e.getMessage());
            }
        }
        scanner.close();
    }
    private static void printHelp() {
        Console.println("Commands:");
        Console.println("  [number]               -> set display to number");
        Console.println("  add/+ value            -> add value");
        Console.println("  subtract/- value       -> subtract value");
        Console.println("  multiply/* value       -> multiply value");
        Console.println("  divide// value         -> divide value");
        Console.println("  square, sqrt           -> square / square root");
        Console.println("  inverse, 1/x           -> inverse");
        Console.println("  sign, neg              -> invert sign");
        Console.println("  sin, cos, tan          -> trig functions");
        Console.println("  asin, acos, atan       -> inverse trig");
        Console.println("  switchunits            -> toggle degrees/radians");
        Console.println("  setunits <degrees|radians> -> set units");
        Console.println("  ln, log, 10^x, e^x     -> logarithmic functions");
        Console.println("  fact                   -> factorial");
        Console.println("  m+, mc, mrc            -> memory functions");
        Console.println("  switchdisplay, setmode -> change display mode");
        Console.println("  clear                  -> clear display");
        Console.println("  help, quit             -> help and exit");
        Console.println("  m2km                   -> Miles to Kilometers");
        Console.println("  km2m                   -> Kilometers to Miles");
        Console.println("  in2cm                  -> inches to centimeters");
        Console.println("  cm2in                  -> centimeters to inches");
    }
    private static double getArgOrPrompt(String arg, String prompt) {
        if (arg != null && isNumeric(arg)) {
            return Double.parseDouble(arg);
        }
        Console.print(prompt);
        String line = scanner.nextLine().trim();
        return Double.parseDouble(line);
    }
    private static boolean isNumeric(String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}