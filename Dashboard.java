package pg.pgfinder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends JFrame implements ActionListener {

    private ArrayList<String> cities; // To dynamically manage cities

    public Dashboard() {
        // Initialize city list
        cities = new ArrayList<>();
        cities.add("Mumbai");
        cities.add("Hyderabad");
        cities.add("Kolkata");
        cities.add("Delhi");

        setLayout(null);
        setBounds(100, 50, 1350, 750);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("proimg/HOMEPAGE.png"));
        Image img2 = im.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);

        image.setBounds(0, 0, 1400, 800);
        add(image);

        JLabel title = new JLabel("WELCOME TO PG ROOM FINDER");
        title.setBounds(100, 70, 1000, 80);
        title.setForeground(Color.black);
        title.setFont(new Font("Tahoma", Font.BOLD, 50));
        image.add(title);

        JMenuBar ab = new JMenuBar();
        ab.setBounds(0, 0, 1550, 30);
        image.add(ab);

        JMenu home = new JMenu("Home");
        home.setBorder(new EmptyBorder(0, 10, 0, 10));
        ab.add(home);

        JMenu pgowners = new JMenu("For PG Owners");
        pgowners.setBorder(new EmptyBorder(0, 10, 0, 10));
        ab.add(pgowners);

        JMenuItem list = new JMenuItem("LIST PG");
        list.addActionListener(this);
        pgowners.add(list);

        JMenuItem rvlist = new JMenuItem("Remove your PG");
        rvlist.addActionListener(this);
        pgowners.add(rvlist);

        JMenu cityMenu = new JMenu("Select City"); // Create city menu
        cityMenu.setBorder(new EmptyBorder(0, 10, 0, 10));
        ab.add(cityMenu);

        // Populate cities in the menu
        for (String cityName : cities) {
            JMenuItem cityItem = new JMenuItem(cityName);
            cityItem.addActionListener(this);
            cityMenu.add(cityItem);
        }

        JMenu cnt = new JMenu("Contact us");
        ab.add(cnt);
        JMenuItem contactItem = new JMenuItem("Contact Us");
        contactItem.addActionListener(this);
        cnt.add(contactItem);

        // New Admin Login Menu
        JMenu adminMenu = new JMenu("Main");
        adminMenu.setBorder(new EmptyBorder(0, 10, 0, 10));
        ab.add(adminMenu);

        JMenuItem adminLoginItem = new JMenuItem("Home Page");
        adminLoginItem.addActionListener(this);
        adminMenu.add(adminLoginItem);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        // Check if the command matches a city name
        if (cities.contains(command)) {
            // Open the respective city page based on the selected city
            openCityPage(command);
        }

        switch (command) {
            case "LIST PG":
                new listPg();  // Modify as per your class
                break;
            case "Remove your PG":
                new removePg();  // Modify as per your class
                break;
            case "Contact Us":
                new contactUs();  // Modify as per your class
                break;
            case "Home Page":
                new PgFinder();  // Open PgFinder page when Admin Login is clicked
                setVisible(false);  // Optionally close the Dashboard
                break;
        }
    }

    // Method to open the respective city page
    private void openCityPage(String cityName) {
        switch (cityName) {
            case "Mumbai":
                new Mumbai();  // Replace with actual city page class
                break;
            case "Hyderabad":
                new Hyderabad();  // Replace with actual city page class
                break;
            case "Kolkata":
                new kolkata();  // Replace with actual city page class
                break;
            case "Delhi":
                new Delhi();  // Replace with actual city page class
                break;
            default:
                JOptionPane.showMessageDialog(this, "No data available for " + cityName);
                break;
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
