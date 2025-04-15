public class Prime{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one number as a command-line argument.");
            return;
        }

        int number = Integer.parseInt(args[0]);

        if (number <= 1) {
            System.out.println(number + " is not a prime number.");
            return;
        }

        int i = 2;
        while (i < number) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime number.");
                return;
            }
            i = i + 1;
        }

        System.out.println(number + " is a prime number.");
    }
}