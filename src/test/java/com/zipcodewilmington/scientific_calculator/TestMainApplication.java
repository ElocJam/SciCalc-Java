public class TestMainApplication {
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
        TestMainApplication calculator = new TestMainApplication();
        Double display = 0.0;
        Boolean running = true;
        Boolean errorState = false;
        while (running) {
             Console.println("Current display: %.2f", calculator.getDisplayValue());
                if (errorState) {
                    String clearInput = Console.getStringInput("Error, please clear before continuing");
                    if (checkForQuit(clearInput)) break;
                    if (checkForClear(clearInput)) {
                        calculator.clear();
                        errorState = false;
                    }
                    continue;
                }
            String firstInput = Console.getStringInput("Please enter first number");
            if (checkForQuit(firstInput)) break;
            if (checkForClear(firstInput)) {
                calculator.clear();
                continue;
            }
            Double firstNumber;
            if (firstInput.trim().isEmpty()) {
                firstNumber = calculator.getDisplayValue();
                Console.println("Using display value: %.2f", firstNumber);
            } else {
                firstNumber = Double.parseDouble(firstInput);
            }
            String operation = Console.getStringInput("Please enter operator");
            if (checkForQuit(operation)) break;
            if (checkForClear(operation)) {
                calculator.clear();
                continue;
            }
            String secondInput = Console.getStringInput("Please enter second number");
            if (checkForQuit(secondInput)) break;
            if (checkForClear(secondInput)) {
                calculator.clear();
                continue;
            }
            Double secondNumber = Double.parseDouble(secondInput);
            calculator.setDisplayValue(firstNumber);
            switch (operation) {
    case "+":
        display = firstNumber + secondNumber;
        break;
    case "-":
        display = firstNumber - secondNumber;
        break;
    case "*":
        display = firstNumber * secondNumber;
        break;
    case "/":
        if (secondNumber == 0) {
            Console.println("Error: Cannot divide by zero");
            errorState = true;
        } else {
            display = firstNumber / secondNumber;
        }
        break;
    default:
        Console.println("Invalid operator");
        errorState = true;
        break;
}
        }
        }
        //MATH CODE
    public double getDisplayValue2() {
    return displayValue;
    }
    public TestMainApplication(double startingValue) {
        this.displayValue = startingValue;
    }
    public void setDisplayValue2(double value) {
        this.displayValue = value;
    }
     public void add(double value) {
        displayValue += value;
    }
    public void subtract(double value) {
        displayValue -= value;
    }
    public void multiply(double value) {
        displayValue *= value;
    }
    public void divide(double value) {
        if (value == 0) {
            System.out.println("Error: Cannot divide by zero.");
            displayValue = Double.NaN; // sets display to "Err" (NaN)
        } else {
            displayValue /= value;
        }
    }
     public void square() {
        displayValue = Math.pow(displayValue, 2);
    }
    public void squareRoot() {
        if (displayValue < 0) {
            System.out.println("Error: Cannot take square root of a negative number.");
            displayValue = Double.NaN;
        } else {
            displayValue = Math.sqrt(displayValue);
        }
    }
    public void exponent(double exponentValue) {
        displayValue = Math.pow(displayValue, exponentValue);
    }
    public void inverse() {
        if (displayValue == 0) {
            System.out.println("Error: Cannot find inverse of zero.");
            displayValue = Double.NaN;
        } else {
            displayValue = 1 / displayValue;
        }
    }
    public void invertSign() {
        displayValue = -displayValue;
    }
    public void clear() {
        displayValue = 0.0;
    }
     private double displayValue;
    private boolean isDegreeMode;
    public void TrigonometricCalculator() {
        this.displayValue = 0.0;
        this.isDegreeMode = true;
    }
    public double getDisplayValue() {
        return displayValue;
    }
    public void setDisplayValue(double displayValue) {
        this.displayValue = displayValue;
    }
    public String getUnitsMode() {
        return isDegreeMode ? "Degrees" : "Radians";
    }
    public void switchUnitsMode() {
        isDegreeMode = !isDegreeMode;
    }
    public void switchUnitsMode(String mode) {
        if (mode.equalsIgnoreCase("degrees")) {
            isDegreeMode = true;
        } else if (mode.equalsIgnoreCase("radians")) {
            isDegreeMode = false;
        } else {
            System.out.println("Invalid mode. Use 'Degrees' or 'Radians'.");
        }
    }
    private double toRadians(double value) {
        return isDegreeMode ? Math.toRadians(value) : value;
    }
    private double toDegrees(double value) {
        return isDegreeMode ? value : Math.toDegrees(value);
    }
    public void sine() {
        displayValue = Math.sin(toRadians(displayValue));
    }
    public void cosine() {
        displayValue = Math.cos(toRadians(displayValue));
    }
    public void tangent() {
        displayValue = Math.tan(toRadians(displayValue));
    }
    public void inverseSine() {
        if (displayValue < -1 || displayValue > 1) {
            displayValue = Double.NaN; // undefined
        } else {
            double result = Math.asin(displayValue);
            displayValue = isDegreeMode ? Math.toDegrees(result) : result;
        }
    }
    public void inverseCosine() {
        if (displayValue < -1 || displayValue > 1) {
            displayValue = Double.NaN;
        } else {
            double result = Math.acos(displayValue);
            displayValue = isDegreeMode ? Math.toDegrees(result) : result;
        }
    }
    public void inverseTangent() {
        double result = Math.atan(displayValue);
        displayValue = isDegreeMode ? Math.toDegrees(result) : result;
    }
}