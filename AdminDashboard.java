package pg.pgfinder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDashboard extends JFrame implements ActionListener {

    JTable table;
    JLabel slogan, name, phn, AdhaarCard, Occupation, anywords, contPeople;
    JButton back, backToLogin; // Add another back button
    DefaultTableModel model;

    AdminDashboard() {
        setLayout(null);
        setBounds(350, 200, 1000, 570); // Increased width to fit the delete button
        getContentPane().setBackground(Color.WHITE);

        slogan = new JLabel("We'll get higher with SUPPORT.");
        slogan.setBounds(150, 0, 500, 100);
        slogan.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(slogan);

        // Set up labels for the columns
        name = new JLabel("Name");
        name.setBounds(20, 250, 200, 100);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(name);

        phn = new JLabel("Phone");
        phn.setBounds(180, 250, 200, 100);
        phn.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(phn);

        AdhaarCard = new JLabel("Adhaar Card");
        AdhaarCard.setBounds(340, 250, 200, 100);
        AdhaarCard.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(AdhaarCard);

        Occupation = new JLabel("Occupation");
        Occupation.setBounds(495, 250, 200, 100);
        Occupation.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(Occupation);

        anywords = new JLabel("Thoughts");
        anywords.setBounds(658, 250, 200, 100);
        anywords.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(anywords);

        contPeople = new JLabel("People who Contacted");
        contPeople.setBounds(18, 210, 260, 100);
        contPeople.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(contPeople);

        // Initialize JTable
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Name", "Phone", "Adhaar Card", "Occupation", "Thoughts", "Action"});
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Only allow editing (clicking) in the last column (Action column)
            }

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (column == 5) { // Change background color for "Delete" button column
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        };

        // Set the editor for the "Action" column to be a JButton
        table.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 310, 950, 200); // Adjusted size to fit the new column
        add(scrollPane);

        // Back button to close admin dashboard
        back = new JButton("Close");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(680, 40, 80, 30);
        back.addActionListener(this);
        add(back);

        // Back to Login button
        backToLogin = new JButton("Back to Dashboard");
        backToLogin.setBackground(Color.BLUE);
        backToLogin.setForeground(Color.WHITE);
        backToLogin.setBounds(580, 40, 120, 30); // Set position for backToLogin button
        backToLogin.addActionListener(this);
        add(backToLogin);

        // Fetch data from the database and display in JTable
        fetchData();

        setVisible(true);
    }

    private void fetchData() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM contact");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("adhaar_card"),
                        rs.getString("occupation"),
                        rs.getString("thoughts"),
                        "Delete"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false); // Close admin dashboard
        } else if (e.getSource() == backToLogin) {
            // Go back to the login page
            setVisible(false); // Close the admin dashboard
            new Dashboard(); // Show the login screen
        }
    }

    // ButtonRenderer class for rendering delete button
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Delete" : value.toString());
            return this;
        }
    }

    // ButtonEditor class for handling button clicks
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            label = (value == null) ? "Delete" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Get the name of the contact to delete based on the selected row
                String nameToDelete = model.getValueAt(selectedRow, 0).toString();

                // Delete the selected row from the database
                try {
                    Conn c = new Conn();
                    String query = "DELETE FROM contact WHERE name='" + nameToDelete + "'";
                    c.s.executeUpdate(query);
                    // Remove the row from the JTable model
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(null, "Contact deleted successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
