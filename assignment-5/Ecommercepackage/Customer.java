package Ecommerce;

public class Customer {
    public String name;
    public int customerId;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
    }

    public String getName() {
        return name;
    }
}
