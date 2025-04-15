import java.util.*;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[2][2];
        int b[][] = new int[2][2];
        int c[][] = new int[2][2];
        int i, j;

        System.out.println("Enter elements of Matrix A:");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nChoose Operation:");
        System.out.println("1: Multiplication");
        System.out.println("2: Addition");
        System.out.println("3: Transpose (of Matrix A)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Matrix Multiplication (A x B):");
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        c[i][j] = 0; // important: initialize before accumulation
                        for (int k = 0; k < 2; k++) {
                            c[i][j] += a[i][k] * b[k][j];
                        }
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("Matrix Addition:");
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        c[i][j] = a[i][j] + b[i][j];
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("Transpose of Matrix A:");
                for (i = 0; i < 2; i++) {
                    for (j = 0; j < 2; j++) {
                        System.out.print(a[j][i] + " ");
                    }
                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }

        
    }
}
