package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton loginButton;

    public AdminLogin() {
        setTitle("Admin Login");
        setLayout(new FlowLayout());

        // Initialize components
        username = new JTextField(15);
        password = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Add components to the frame
        add(new JLabel("Admin Username:"));
        add(username);
        add(new JLabel("Password:"));
        add(password);
        add(loginButton);

        // Action listener for the login button
        loginButton.addActionListener(this);

        // Set frame properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get the entered username and password
        String enteredUsername = username.getText();
        String enteredPassword = new String(password.getPassword());

        // Check if the credentials match
        if (enteredUsername.equals("admin") && enteredPassword.equals("admin@123")) {
            // Show success message and open admin dashboard
            JOptionPane.showMessageDialog(this, "Admin Login Successful!");
            new AdminDashboard();  // Open the Dashboard
            setVisible(false);  // Close the login window
        } else {
            // Show error message
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
        }
    }

    public static void main(String[] args) {
        new AdminLogin();  // Open the AdminLogin window
    }
}
