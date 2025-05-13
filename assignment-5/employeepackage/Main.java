import employee.Employee;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "sarvesh", "Engineering", 75000);
        Employee emp2 = new Employee(102, "swarup", "Marketing", 65000);

        emp1.displayInfo();
        emp2.displayInfo();
    }
}
