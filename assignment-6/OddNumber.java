class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

public class OddNumber {

    public static void checkEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Error: " + number + " is an odd number.");
        } else {
            System.out.println(number + " is an even number.");
        }
    }

    public static void main(String[] args) {
        int inputNumber = 7;  // You can change this value for testing

        try {
            checkEven(inputNumber);
        } catch (OddNumberException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
