package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listPg extends JFrame implements ActionListener {

    JTextField tfname, tfmobile, tfcity, tfaddr, mail;
    JRadioButton jr, jrweek;
    JButton sub, back;

    listPg() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("List PG");

        JLabel lbldtl = new JLabel("Enter Your Details");
        lbldtl.setBounds(60, 30, 180, 30);
        lbldtl.setFont(new Font("tahoma", Font.BOLD, 17));
        add(lbldtl);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 70, 120, 30);
        lblname.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel lblcon = new JLabel("Mobile");
        lblcon.setBounds(60, 110, 120, 30);
        lblcon.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblcon);

        tfmobile = new JTextField();
        tfmobile.setBounds(200, 110, 150, 30);
        add(tfmobile);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(60, 150, 120, 30);
        lblcity.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(200, 150, 150, 30);
        add(tfcity);

        JLabel lbltime = new JLabel("Preferred time to call");
        lbltime.setBounds(60, 190, 200, 30);
        lbltime.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lbltime);

        jr = new JRadioButton("10am-6pm");
        jr.setBounds(250, 190, 120, 30);
        jr.setFont(new Font("tahoma", Font.PLAIN, 17));
        jr.setBackground(Color.white);
        add(jr);

        jrweek = new JRadioButton("Weekends");
        jrweek.setBounds(380, 190, 120, 30);
        jrweek.setFont(new Font("tahoma", Font.PLAIN, 17));
        jrweek.setBackground(Color.white);
        add(jrweek);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jr);
        bg.add(jrweek);

        JLabel lbladdr = new JLabel("PG Address");
        lbladdr.setBounds(60, 230, 120, 30);
        lbladdr.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lbladdr);

        tfaddr = new JTextField();
        tfaddr.setBounds(200, 230, 150, 30);
        add(tfaddr);

        JLabel lblmail = new JLabel("Email");
        lblmail.setBounds(60, 270, 120, 30);
        lblmail.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblmail);

        mail = new JTextField();
        mail.setBounds(200, 270, 150, 30);
        add(mail);

        sub = new JButton("SUBMIT");
        sub.setBackground(Color.black);
        sub.setForeground(Color.white);
        sub.setBounds(100, 320, 120, 40);
        sub.addActionListener(this);
        add(sub);

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 320, 120, 40);
        back.addActionListener(this);
        add(back);

        setBounds(350, 200, 500, 450);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        } else {
            String name = tfname.getText();
            String mobile = tfmobile.getText();
            String city = tfcity.getText();
            String pgaddr = tfaddr.getText();
            String email = mail.getText();
            String preferredTimeToCall = null;

            if (jr.isSelected()) {
                preferredTimeToCall = "10am-6pm";
            } else if (jrweek.isSelected()) {
                preferredTimeToCall = "Weekends";
            }

            // Validate if all fields are filled
            if (name.isEmpty() || mobile.isEmpty() || city.isEmpty() || pgaddr.isEmpty() || email.isEmpty() || preferredTimeToCall == null) {
                JOptionPane.showMessageDialog(null, "All fields are mandatory. Please fill in all details.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Conn conn = new Conn();
                    String query = "INSERT INTO listpg (name, mobile, city, PreferredTimeToCall, pgaddr, email) VALUES('" 
                    + name + "', '" 
                    + mobile + "','" 
                    + city + "','" 
                    + preferredTimeToCall + "','" 
                    + pgaddr + "','" 
                    + email + "')";

                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your PG has been listed successfully.");
                    setVisible(false);
                } catch (Exception ae) {
                    ae.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred while listing PG.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new listPg();
    }
}
