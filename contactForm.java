package pg.pgfinder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contactForm extends JFrame implements ActionListener {

    JTextField tfname, tfmobile, tfadhaar, tfthoughts, tfoccupation;
    JButton call, back;

    contactForm() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Contact PG Owner");

        JMenuBar ab = new JMenuBar();
        ab.setBounds(0, 0, 1550, 60);
        ab.setBackground(Color.darkGray);
        add(ab);

        JMenu mum = new JMenu("Contact PG Owner");
        mum.setForeground(Color.white);
        mum.setBorder(new EmptyBorder(5, 25, 0, 20));
        mum.setFont(new Font("tahoma", Font.BOLD, 30));
        ab.add(mum);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 120, 30);
        lblname.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);

        JLabel lblcon = new JLabel("Mobile");
        lblcon.setBounds(60, 150, 120, 30);
        lblcon.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblcon);

        tfmobile = new JTextField();
        tfmobile.setBounds(200, 150, 150, 30);
        add(tfmobile);

        JLabel lbladhaar = new JLabel("Aadhaar Card");
        lbladhaar.setBounds(60, 220, 120, 30);
        lbladhaar.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lbladhaar);

        tfadhaar = new JTextField();
        tfadhaar.setBounds(200, 220, 150, 30);
        add(tfadhaar);

        JLabel lbloccupation = new JLabel("Occupation");
        lbloccupation.setBounds(60, 290, 120, 30);
        lbloccupation.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lbloccupation);

        tfoccupation = new JTextField();
        tfoccupation.setBounds(200, 290, 150, 30);
        add(tfoccupation);

        JLabel lblthoughts = new JLabel("Thoughts");
        lblthoughts.setBounds(60, 370, 120, 30);
        lblthoughts.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblthoughts);

        tfthoughts = new JTextField();
        tfthoughts.setBounds(200, 370, 160, 60);
        add(tfthoughts);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("proimg/conversation.png"));
        Image img2 = im.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(500, 100, 250, 250);
        add(image);

        call = new JButton("Contact");
        call.setBackground(Color.black);
        call.setForeground(Color.white);
        call.setBounds(450, 420, 100, 40);
        call.setFont(new Font("serif", Font.PLAIN, 20));
        call.addActionListener(this);
        add(call);

        back = new JButton("Back");
        back.setBounds(600, 420, 100, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("tahoma", Font.PLAIN, 18));
        back.addActionListener(this);
        add(back);

        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else {
            String name = tfname.getText();
            String mobile = tfmobile.getText();
            String adhaarCard = tfadhaar.getText();
            String occupation = tfoccupation.getText();
            String thoughts = tfthoughts.getText();

            // Validate mobile number
            if (!isValidMobile(mobile)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit mobile number.");
                return;
            }

            // Validate Aadhaar card number
            if (!isValidAadhaar(adhaarCard)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhaar number.");
                return;
            }

            if (name.isEmpty() || mobile.isEmpty() || adhaarCard.isEmpty() || occupation.isEmpty() || thoughts.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory. Please fill out all information.");
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO contact VALUES('" + name + "', '" + mobile + "','" + adhaarCard + "','" + occupation + "','" + thoughts + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "The PG Owner will contact you shortly.");
                    setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        }
    }

    // Method to validate mobile number
    private boolean isValidMobile(String mobile) {
        return mobile.matches("\\d{10}");
    }

    // Method to validate Aadhaar card number
    private boolean isValidAadhaar(String adhaarCard) {
        return adhaarCard.matches("\\d{12}");
    }

    public static void main(String[] args) {
        new contactForm();
    }
}
