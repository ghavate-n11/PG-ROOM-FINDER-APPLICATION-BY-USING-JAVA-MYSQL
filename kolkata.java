package pg.pgfinder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class kolkata extends JFrame implements ActionListener {

    JButton back, contact1, contact2, contact3;

    kolkata() {
        setLayout(new BorderLayout());
        setTitle("PG in Kolkata");
        setSize(1400, 640);
        setLocation(100, 100);

        // Create a menu bar
        JMenuBar ab = new JMenuBar();
        ab.setBackground(Color.darkGray);
        add(ab, BorderLayout.NORTH);

        JMenu mum = new JMenu("PG IN Kolkata");
        mum.setForeground(Color.white);
        mum.setBorder(new EmptyBorder(5, 25, 0, 20));
        mum.setFont(new Font("Tahoma", Font.BOLD, 50));
        ab.add(mum);

        // Create a panel to hold the PG details
        JPanel pgPanel = new JPanel();
        pgPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows for 3 PGs
        pgPanel.setBorder(new EmptyBorder(20, 50, 20, 50)); // Add some padding
        add(pgPanel, BorderLayout.CENTER);

        // PG 1 Details
        JPanel pg1 = createPGPanel(
                "Sunshine PG",
                "Salt Lake, Kolkata, West Bengal",
                "₹ 8000 per month onwards",
                "Owner: Mr. Sunil",
                "Contact: 9876543211",
                "A clean and affordable PG with easy access to public transportation.",
                "proimg/kolkata.png",
                contact1 = new JButton("Contact")
        );
        pgPanel.add(pg1);

        // PG 2 Details
        JPanel pg2 = createPGPanel(
                "City View PG",
                "Park Street, Kolkata, West Bengal",
                "₹ 9500 per month onwards",
                "Owner: Mr. Rajesh",
                "Contact: 9876543222",
                "Well-maintained PG with air-conditioned rooms and Wi-Fi facilities.",
                "proimg/kolkata.png",
                contact2 = new JButton("Contact")
        );
        pgPanel.add(pg2);

        // PG 3 Details
        JPanel pg3 = createPGPanel(
                "Elite PG",
                "Gariahat, Kolkata, West Bengal",
                "₹ 10000 per month onwards",
                "Owner: Mrs. Priya",
                "Contact: 9876543233",
                "Affordable PG with food and laundry services included.",
                "proimg/kolkatta.png",
                contact3 = new JButton("Contact")
        );
        pgPanel.add(pg3);

        // Back button at the bottom
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma", Font.PLAIN, 18));
        back.addActionListener(this);
        add(back, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Helper method to create a panel for each PG entry
    private JPanel createPGPanel(String pgName, String address, String rent, String ownerName, String contactInfo, String description, String imagePath, JButton contactButton) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Add border for clarity

        // Left side image
        JLabel imageLabel = new JLabel();
        try {
            ImageIcon im = new ImageIcon(ClassLoader.getSystemResource(imagePath));
            Image img = im.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("Image not found");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }
        panel.add(imageLabel, BorderLayout.WEST);

        // Right side text information
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1)); // 5 rows for PG info
        infoPanel.add(new JLabel(pgName));
        infoPanel.add(new JLabel(address));
        infoPanel.add(new JLabel(rent));
        infoPanel.add(new JLabel(ownerName));
        infoPanel.add(new JLabel(contactInfo));
        panel.add(infoPanel, BorderLayout.CENTER);

        // Create a panel for description and contact button
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BorderLayout());

        // Description Label
        JLabel descriptionTitle = new JLabel("Description of " + pgName);
        descriptionTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        descriptionPanel.add(descriptionTitle, BorderLayout.NORTH);

        // Description label with HTML for wrapping
        JLabel descriptionLabel = new JLabel("<html><body style='width: 250px;'>" + description + "</body></html>");
        descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);

        // Contact button below the description
        contactButton.setBackground(Color.black);
        contactButton.setForeground(Color.white);
        contactButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contactButton.addActionListener(this); // Add action listener
        descriptionPanel.add(contactButton, BorderLayout.SOUTH);

        panel.add(descriptionPanel, BorderLayout.EAST); // Add the description panel to the east side

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            JOptionPane.showMessageDialog(this, "Going back to the previous page.");
            dispose(); // Close the current window
        } else if (e.getSource() == contact1) {
            // Create and show the contact form when the contact button is clicked
            new contactForm();
        } else if (e.getSource() == contact2) {
            // Create and show the contact form when the contact button is clicked
            new contactForm();
        } else if (e.getSource() == contact3) {
            // Create and show the contact form when the contact button is clicked
            new contactForm();
        }
    }
    

    public static void main(String[] args) {
        new kolkata();
    }
}
