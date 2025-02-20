package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class removePg extends JFrame implements ActionListener {

    JTextField tfName; // Changed from tfpgid to tfName
    JButton rem, back;

    removePg() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Remove PG");

        JLabel lbldtl = new JLabel("Enter Customer Name to Remove PG");
        lbldtl.setBounds(60, 10, 300, 30);
        add(lbldtl);
        lbldtl.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblName = new JLabel("Customer Name");
        lblName.setBounds(60, 80, 120, 30);
        add(lblName);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));

        tfName = new JTextField();
        tfName.setBounds(200, 80, 150, 30);
        add(tfName);

        rem = new JButton("REMOVE PG");
        rem.setBackground(Color.black);
        rem.setForeground(Color.white);
        rem.setBounds(100, 160, 150, 40);
        rem.addActionListener(this);
        add(rem);

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 160, 120, 40);
        back.addActionListener(this);
        add(back);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("proimg/thank-you.png"));
        Image img2 = im.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(500, 100, 250, 250);
        add(image);

        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == rem) {
            String customerName = tfName.getText().trim(); // Get the customer name and trim whitespace

            // Check if the customer name field is empty
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Customer Name field is mandatory. Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if customer name is empty
            }

            try {
                Conn conn = new Conn();
                String query = "DELETE FROM listpg WHERE name = '" + customerName + "'"; // Updated query to use customer name
                int rowsAffected = conn.s.executeUpdate(query);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "PG listed by " + customerName + " has been removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No PG found listed by the provided customer name.");
                }
                setVisible(false);
            } catch (SQLException ae) {
                ae.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new removePg();
    }
}
