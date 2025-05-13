import java.util.Scanner;

class Stack {
    int size = 6;
    int[] stk = new int[size];
    int top = -1;
    
    Stack() {
        top = -1;
    }
    
    void push() {
        if (top == size - 1) {
            System.out.println("Cannot push the element, stack is full!");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter element to push: ");
            int n = sc.nextInt();
            top++;
            stk[top] = n;
        }
    }
    
    void pop() {
        if (top == -1) {
            System.out.println("Cannot pop element, stack is empty");
        } else {
            int n = stk[top];
            top--;
            System.out.println("Popped element: " + n);
        }
    }
    
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stk[i]);
            }
        }
    }
}

public class StackOp {
    public static void main(String[] args) {
        Stack s= new Stack();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
        
        
    }
}