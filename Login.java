package pg.pgfinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, back;

    Login() {
        setLayout(null);
        setSize(1400, 565);
        setLocation(100, 100);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("proimg/login.png"));
        Image img2 = im.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);

        image.setBounds(400, 30, 150, 150);
        add(image);

        JLabel user = new JLabel("Username");
        user.setBounds(100, 20, 100, 30);
        user.setForeground(Color.black);
        add(user);

        username = new JTextField();
        username.setBounds(210, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(100, 70, 100, 30);
        pass.setForeground(Color.black);
        add(pass);

        password = new JPasswordField();
        password.setBounds(210, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(200, 150, 100, 40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);  // Add the event listener
        add(login);

        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(50, 150, 100, 40);
        back.addActionListener(this);
        add(back);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {
            setVisible(false);
        } else {
            String user = username.getText();
            @SuppressWarnings("deprecation")
            final String pass = password.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username ='" + user + "'and password ='" + pass + "' ";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();  // Open Dashboard after successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
