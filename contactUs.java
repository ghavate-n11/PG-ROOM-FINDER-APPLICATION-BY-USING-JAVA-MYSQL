package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contactUs extends JFrame implements ActionListener {

    JButton back, sendButton;
    JTextField nameTextField, numberTextField, emailTextField, messageTextField, cityTextField;

    contactUs() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("Contact US");
        setSize(1400, 640);
        setLocation(100, 100);

        JLabel lbldtl = new JLabel("IT’S EASY TO FIND US");
        lbldtl.setBounds(60, 30, 300, 30);
        lbldtl.setForeground(Color.black);
        lbldtl.setFont(new Font("tahoma", Font.BOLD, 22));
        add(lbldtl);

        JLabel lbladdr = new JLabel("Address");
        lbladdr.setBounds(60, 100, 200, 20);
        lbladdr.setFont(new Font("tahoma", Font.BOLD, 17));
        lbladdr.setForeground(Color.DARK_GRAY);
        add(lbladdr);

        JLabel lblabout = new JLabel("<html>TEJAS HOUSING PLOT,<br>" +
                "Office No.6, Second Floor, Oxford Tower (commercial),Opp.<br>" +
                
                "Mirgane Complex, Latur Road, Barshi, Maharashtra, India</html>");
        lblabout.setBounds(60, 150, 500, 100);
        lblabout.setFont(new Font("tahoma", Font.PLAIN, 17));
        lblabout.setForeground(Color.DARK_GRAY);
        add(lblabout);

        JLabel lblcont = new JLabel("Contact Details");
        lblcont.setBounds(60, 300, 200, 30);
        lblcont.setFont(new Font("tahoma", Font.BOLD, 17));
        add(lblcont);

        JLabel lblnumb = new JLabel("9356471182");
        lblnumb.setBounds(100, 350, 200, 30);
        lblnumb.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblnumb);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("proimg/phone-call.png"));
        Image img2 = im.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(60, 355, 25, 25);
        add(image);

        JLabel lblfax = new JLabel("079- 40056331");
        lblfax.setBounds(100, 400, 200, 30);
        lblfax.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblfax);

        ImageIcon im4 = new ImageIcon(ClassLoader.getSystemResource("proimg/fax-machine.png"));
        Image img5 = im4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img5);
        JLabel image1 = new JLabel(img6);
        image1.setBounds(60, 400, 25, 25);
        add(image1);

        JLabel lblmail = new JLabel("nileshbghavate@coep.sveri.ac.in");
        lblmail.setBounds(100, 450, 250, 30);
        lblmail.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblmail);

        ImageIcon im6 = new ImageIcon(ClassLoader.getSystemResource("proimg/email.png"));
        Image img7 = im6.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon img8 = new ImageIcon(img7);
        JLabel image2 = new JLabel(img8);
        image2.setBounds(60, 450, 25, 25);
        add(image2);

        JLabel lbltime = new JLabel("Working Hours");
        lbltime.setBounds(500, 300, 250, 30);
        lbltime.setFont(new Font("tahoma", Font.BOLD, 17));
        add(lbltime);

        JLabel lblhour = new JLabel("<html>Mon - Fri : 6 a.m. to 8 p.m.<br>" +
                "Sat - Sun: 9 a.m. to 2 p.m.</html>");
        lblhour.setBounds(500, 350, 250, 60);
        lblhour.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblhour);

        JLabel lblmssg = new JLabel("Send Us a Message");
        lblmssg.setBounds(900, 50, 300, 30);
        lblmssg.setFont(new Font("tahoma", Font.BOLD, 17));
        add(lblmssg);

        cityTextField = new JTextField("*City");
        cityTextField.setBounds(900, 120, 300, 30);
        add(cityTextField);

        nameTextField = new JTextField("*Name");
        nameTextField.setBounds(900, 180, 300, 30);
        add(nameTextField);

        numberTextField = new JTextField("*Number");
        numberTextField.setBounds(900, 240, 300, 30);
        add(numberTextField);

        emailTextField = new JTextField("*Email");
        emailTextField.setBounds(900, 300, 300, 30);
        add(emailTextField);

        messageTextField = new JTextField("*Message");
        messageTextField.setBounds(900, 360, 300, 120);
        add(messageTextField);

        sendButton = new JButton("Send Message");
        sendButton.setBounds(1000, 500, 120, 35);
        sendButton.setBackground(Color.black);
        sendButton.setForeground(Color.white);
        sendButton.setFont(new Font("tahoma", Font.PLAIN, 12));
        sendButton.addActionListener(this);
        add(sendButton);

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(1000, 550, 120, 30);
        back.setFont(new Font("tahoma", Font.PLAIN, 12));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else if (e.getSource() == sendButton) {
            String name = nameTextField.getText();
            String number = numberTextField.getText();
            String email = emailTextField.getText();
            String message = messageTextField.getText();
            String city = cityTextField.getText();

            // Check if any field is empty or has a default placeholder value
            if (name.equals("*Name") || name.isEmpty() ||
                number.equals("*Number") || number.isEmpty() ||
                email.equals("*Email") || email.isEmpty() ||
                message.equals("*Message") || message.isEmpty() ||
                city.equals("*City") || city.isEmpty()) {

                // Show error message if any field is missing
                JOptionPane.showMessageDialog(null, "All fields are mandatory. Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Conn conn = new Conn();
                    // Corrected SQL query
                    String query = "INSERT INTO message (name, number, mail, message) VALUES ('" 
                                + name + "', '" 
                                + number + "','" 
                                + email + "','"  
                                + message + "')";  
                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Thanks for Contacting. We appreciate your time.");
                    setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new contactUs();  // Create an instance of the contactUs class
    }
}
