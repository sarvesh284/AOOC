import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewAll extends JFrame {
    JTable table;
    DefaultTableModel model;

    public ViewAll() {
        setTitle("All Expenses");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columns = {"Description", "Date", "Category", "Amount"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        loadTableData(); // Load data from ExpenseData

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Delete button
        JButton deleteBtn = new JButton("Delete Selected");
        deleteBtn.addActionListener(e -> deleteSelectedRow());
        add(deleteBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadTableData() {
        model.setRowCount(0); // Clear existing rows
        List<String[]> data = ExpenseData.getExpenses();
        for (String[] row : data) {
            model.addRow(row);
        }
    }

    private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            // Remove from ExpenseData list
            ExpenseData.getExpenses().remove(selectedRow);

            // Refresh table model
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
}
