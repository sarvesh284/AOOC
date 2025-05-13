import java.util.Scanner;

class Queue {
    int size = 6;
    int[] que = new int[size];
    int front = -1;
    int rear = -1;
    
    Queue() {
        front = -1;
        rear = -1;
    }
    
    void enqueue() {
        if (isOverflow()) {
            System.out.println("Cannot enqueue the element, queue is full!");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter element to enqueue: ");
            int n = sc.nextInt();
            
            if (front == -1) {
                front = 0;
            }
            
            rear = (rear + 1) % size;
            que[rear] = n;
        }
    }
    
    void dequeue() {
        if (isUnderflow()) {
            System.out.println("Cannot dequeue element, queue is empty");
        } else {
            int n = que[front];
            
            if (front == rear) {
                // Last element in the queue
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            
            System.out.println("Dequeued element: " + n);
        }
    }
    
    boolean isOverflow() {
        return (rear + 1) % size == front;
    }
    
    boolean isUnderflow() {
        return front == -1;
    }
    
    void overflow() {
        if (isOverflow()) {
            System.out.println("Queue Overflow! Queue is full and cannot accept more elements.");
        } else {
            System.out.println("Queue is not full. You can enqueue more elements.");
            System.out.println("Available space: " + availableSpace() + " element(s)");
        }
    }
    
    void underflow() {
        if (isUnderflow()) {
            System.out.println("Queue Underflow! Queue is empty and cannot dequeue elements.");
        } else {
            System.out.println("Queue is not empty. You can dequeue elements.");
            System.out.println("Current queue size: " + currentSize() + " element(s)");
        }
    }
    
    // Helper methods for overflow and underflow reporting
    int currentSize() {
        if (front == -1) return 0;
        return (rear >= front) ? (rear - front + 1) : (size - front + rear + 1);
    }
    
    int availableSpace() {
        return size - currentSize() - 1; // -1 because one space is always kept empty in circular queue
    }
    
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements:");
            int i = front;
            do {
                System.out.println(que[i]);
                i = (i + 1) % size;
            } while (i != (rear + 1) % size);
        }
    }
}

public class QueueOp {
    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Check Overflow Status");
            System.out.println("5. Check Underflow Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    q.enqueue();
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    q.overflow();
                    break;
                case 5:
                    q.underflow();
                    break;
                case 6:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
    }
}