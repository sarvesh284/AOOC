import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Convert string to character array
        char[] characters = input.toCharArray();
        
        // Implementing bubble sort manually
        for (int i = 0; i < characters.length - 1; i++) {
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (characters[j] > characters[j + 1]) {
                     // Swap characters
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                }
            }
        }
        
        // Convert back to string and display the sorted result
        String sortedString = new String(characters);
        System.out.println("Sorted string: " + sortedString);
        
        scanner.close();
    }
}
