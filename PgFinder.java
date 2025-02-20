package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class PgFinder extends JFrame {

    JButton adminLogin, userLogin, ownerLogin;

    public PgFinder() {
        // Set JFrame properties
        setTitle("PG Availability Checker");
        setSize(1400, 700);
        setLocation(100, 100);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background Image Setup
        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("proimg/mumbai5.png"));
        Image img = imgIcon.getImage().getScaledInstance(1400, 700, Image.SCALE_SMOOTH);
        JLabel backgroundImage = new JLabel(new ImageIcon(img));
        backgroundImage.setBounds(0, 0, 1400, 700);
        add(backgroundImage);

        // Title Section
        JLabel title = new JLabel("PG AVAILABILITY CHECKER", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(200, 50, 1000, 100);
        title.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        title.setOpaque(true);
        title.setBackground(new Color(0, 51, 102));
        backgroundImage.add(title);

        // Button Section
        adminLogin = new JButton("Admin Login");
        adminLogin.setBounds(300, 250, 200, 50);
        adminLogin.setFont(new Font("Arial", Font.BOLD, 18));
        adminLogin.setForeground(Color.WHITE);
        adminLogin.setBackground(new Color(50, 150, 250));
        adminLogin.setBorder(new LineBorder(Color.BLACK, 2, true));
        adminLogin.setFocusPainted(false);
        adminLogin.addActionListener(e -> openAdminLogin());
        backgroundImage.add(adminLogin);

        userLogin = new JButton("Dashboard");
        userLogin.setBounds(600, 250, 200, 50);
        userLogin.setFont(new Font("Arial", Font.BOLD, 18));
        userLogin.setForeground(Color.WHITE);
        userLogin.setBackground(new Color(50, 150, 250));
        userLogin.setBorder(new LineBorder(Color.BLACK, 2, true));
        userLogin.setFocusPainted(false);
        userLogin.addActionListener(e -> openDashboard());
        backgroundImage.add(userLogin);

        

        setVisible(true);
    }

    // Method to open Admin login
    private void openAdminLogin() {
        new AdminLogin();
    }

    private void openDashboard() {
        // Opens Dashboard
        new Dashboard(); // Redirects to the Dashboard after user login
    setVisible(false); // Optionally close the PgFinder frame
    }

    

    public static void main(String[] args) {
        new PgFinder();
    }
}
