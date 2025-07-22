//
// create the package named as pgfinder first then create some files otherwise it should gives error not runs 100%  CONTACT ME: nileshghavate11@gmail.com
package pg.pgfinder;
//import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Change the database URL, username, and password as per your database configuration
            String url = "jdbc:mysql://localhost:3306/pgchecker"; // Update with your DB name
            String username = "root"; // Update with your DB username
            String password = "root@1234"; // Update with your DB password

            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
