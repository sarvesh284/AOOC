package LibraryManagement;

import java.util.Scanner;
public class Member {
     String name;
     int id;
    
    public void getMemberInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        this.name = sc.nextLine();
        System.out.println("Enter the id of member:");
        this.id = sc.nextInt();
    }
    
    public void setMemberInfo() {
        System.out.println("Name of member: " + name);
        System.out.println("ID of member: " + id);
    }
}