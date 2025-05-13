import java.awt.*;
import javax.swing.*;

public class AddExpense extends JFrame {
    JPanel panel;
    JLabel description, date, category, amount;
    JTextField dTextField, daTextField, cTextField, aTextField;
    JButton addButton;
    private ExpenseTracker parent;

    public AddExpense(ExpenseTracker parent) {
        this.parent = parent;

        // Set the frame title, layout, and size
        setTitle("Add Expense");
        setSize(600, 400); 
        setLocationRelativeTo(null); 

        setLayout(new BorderLayout());

        // Create a panel for the form with GridLayout
        panel = new JPanel(new GridLayout(5, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        panel.setPreferredSize(new Dimension(400, 300)); 
        panel.setBackground(new Color(50, 50, 50));

        // Create form components (labels, text fields)
        description = new JLabel("Description:");
        description.setForeground(Color.white);
        dTextField = new JTextField();

        date = new JLabel("Date:");
        date.setForeground(Color.white);
        daTextField = new JTextField();

        category = new JLabel("Category:");
        category.setForeground(Color.white);
        cTextField = new JTextField();

        amount = new JLabel("Amount:");
        amount.setForeground(Color.white);
        aTextField = new JTextField();

        addButton = new JButton("Add");
        addButton.setBackground(new Color(30,30,30));
        addButton.setForeground(Color.WHITE);

        // Add components to the panel
        panel.add(description); panel.add(dTextField);
        panel.add(date); panel.add(daTextField);
        panel.add(category); panel.add(cTextField);
        panel.add(amount); panel.add(aTextField);
        panel.add(new JLabel()); panel.add(addButton); 

        addButton.addActionListener(e -> {
            String desc = dTextField.getText();
            String date = daTextField.getText();
            String cat = cTextField.getText();
            String amt = aTextField.getText();

            if (!desc.isEmpty() && !date.isEmpty() && !cat.isEmpty() && !amt.isEmpty()) {
                ExpenseData.addExpense(desc, date, cat, amt);
                parent.refreshTotalExpense(); // <-- update the total expense live
                JOptionPane.showMessageDialog(this, "Expense Added!");
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add panel to the center of the frame using BorderLayout.CENTER
        add(panel, BorderLayout.CENTER);

        setResizable(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddExpense(null));  // Should not be used standalone
    }
}
