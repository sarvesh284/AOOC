import java.util.ArrayList;
import java.util.List;

public class ExpenseData {
    private static List<String[]> expenses = new ArrayList<>();
    private static double saving = 0;
    private static double income = 0;

    public static void addExpense(String description, String date, String category, String amount) {
        expenses.add(new String[]{description, date, category, amount});
    }

    public static List<String[]> getExpenses() {
        return expenses;
    }

    public static double getTotalExpense() {
        double total = 0;
        for (String[] expense : expenses) {
            total += Double.parseDouble(expense[3]);
        }
        return total;
    }

    public static void setSaving(double newSaving) {
        saving = newSaving;
    }

    public static double getSaving() {
        return saving;
    }

    public static void setIncome(double newIncome) {
        income = newIncome;
    }

    public static double getIncome() {
        return income;
    }

    public static void loadData() {
        // This method should load data from a file or database (not implemented here)
    }

    public static void saveData() {
        // This method should save data to a file or database (not implemented here)
    }
}
