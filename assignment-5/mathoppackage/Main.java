// File: Main.java
import MathOperations.MathFunctions;

public class Main {
    public static void main(String[] args) {
        MathFunctions math = new MathFunctions();

        double number1 = 5.8;
        double number2 = 2.3;
        double number3 = -4.6;

        System.out.println("Using MathFunctions:");

        System.out.println("Floor of " + number1 + ": " + math.floor(number1));
        System.out.println("Ceil of " + number2 + ": " + math.ceil(number2));
        System.out.println("Round of " + number3 + ": " + math.round(number3));
    }
}
