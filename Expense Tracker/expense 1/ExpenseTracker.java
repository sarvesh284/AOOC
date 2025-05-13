import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExpenseTracker extends JFrame implements ActionListener {
    JPanel saving, mIncome, expense;
    JLabel sLabel, iLabel, eLabel, savingLabel, mIncomeLabel;
    JTextField sTextField, iTextField, eTextField, savingTextField, mIncomTextField;
    JButton addExpenseBtn, viewAllBtn, addButton;

    public ExpenseTracker() {
        setTitle("Expense Tracker");
        setSize(1000, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- LEFT TOOLBAR --------
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(200, getHeight()));
        leftPanel.setBackground(new Color(30, 30, 30));

        JToolBar verticalMenu = new JToolBar(JToolBar.VERTICAL);
        verticalMenu.setFloatable(false);
        verticalMenu.setBackground(new Color(30, 30, 30));
        verticalMenu.setBorderPainted(false);
        verticalMenu.setLayout(new GridLayout(6, 1, 0, 10));

        String[] buttons = {"Profile", "Dashboard", "Add Expense", "View All", "Reports", "Settings"};
        for (String name : buttons) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(50, 50, 50));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            btn.setPreferredSize(new Dimension(90, 10));

            if (name.equals("Add Expense")) {
                addExpenseBtn = btn;
                addExpenseBtn.addActionListener(this);
            }

            if (name.equals("View All")) {
                viewAllBtn = btn;
                viewAllBtn.addActionListener(this);
            }

            verticalMenu.add(btn);
        }

        leftPanel.add(verticalMenu, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        // -------- MAIN CONTENT AREA --------
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        add(mainContent, BorderLayout.CENTER);

        // -------- PANELS --------
        saving = new JPanel();
        mIncome = new JPanel();
        expense = new JPanel();

        saving.setBackground(new Color(50, 50, 50));
        mIncome.setBackground(new Color(50, 50, 50));
        expense.setBackground(new Color(50, 50, 50));

        saving.setPreferredSize(new Dimension(300, 150));
        mIncome.setPreferredSize(new Dimension(300, 150));
        expense.setPreferredSize(new Dimension(300,150));

        sLabel = new JLabel("Saving");
        sLabel.setForeground(Color.WHITE);
        iLabel = new JLabel("Monthly Income");
        iLabel.setForeground(Color.WHITE);
        eLabel = new JLabel("Expense");
        eLabel.setForeground(Color.WHITE);

        sTextField = new JTextField(15);
        iTextField = new JTextField(15);
        eTextField = new JTextField(15);

        saving.add(sLabel);
        saving.add(sTextField);

        mIncome.add(iLabel);
        mIncome.add(iTextField);

        expense.add(eLabel);
        expense.add(eTextField);

        mainContent.add(saving);
        mainContent.add(mIncome);
        mainContent.add(expense);
        mainContent.setBackground(new Color(30, 30, 30));

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        secondRow.setBackground(new Color(50, 50, 50));

        savingLabel = new JLabel("Current Saving");
        savingLabel.setForeground(Color.WHITE);
        savingTextField = new JTextField(10);

        mIncomeLabel = new JLabel("Monthly Income");
        mIncomeLabel.setForeground(Color.WHITE);
        mIncomTextField = new JTextField(10);

        addButton = new JButton("Add");
        addButton.addActionListener(this);

        secondRow.add(savingLabel);
        secondRow.add(savingTextField);
        secondRow.add(mIncomeLabel);
        secondRow.add(mIncomTextField);
        secondRow.add(addButton);

        mainContent.add(secondRow);

        // Load saved data
        ExpenseData.loadData();
        sTextField.setText(String.valueOf(ExpenseData.getSaving()));
        iTextField.setText(String.valueOf(ExpenseData.getIncome()));
        eTextField.setText(String.valueOf(ExpenseData.getTotalExpense()));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addExpenseBtn) {
            new AddExpense(this);
        } else if(e.getSource() == viewAllBtn) {
            new ViewAll();
        }

        if (e.getSource() == addButton) {
            try {
                double savings = Double.parseDouble(savingTextField.getText());
                double income = Double.parseDouble(mIncomTextField.getText());

                // Set text fields in first row
                sTextField.setText(String.valueOf(savings));
                iTextField.setText(String.valueOf(income));

                // Save to ExpenseData
                ExpenseData.setSaving(savings);
                ExpenseData.setIncome(income);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        }
    }

    // Method to update the total expense text field
    public void refreshTotalExpense() {
        eTextField.setText(String.valueOf(ExpenseData.getTotalExpense()));
    }

    public static void main(String[] args) {
        new ExpenseTracker();
    }
}
