package LibraryManagement;

import java.util.Scanner;

public class Book {
     String title, author;
     int ISBN;
    
    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of book");
        title = sc.nextLine();
        System.out.println("Enter the author's name of book");
        author = sc.nextLine();
        System.out.println("Enter the ISBN of book");
        ISBN = sc.nextInt();
    }
    
    public void setInfo() {
        System.out.println("Title of book: " + title);
        System.out.println("Author's name of book: " + author);
        System.out.println("ISBN of book: " + ISBN);
    }
}
