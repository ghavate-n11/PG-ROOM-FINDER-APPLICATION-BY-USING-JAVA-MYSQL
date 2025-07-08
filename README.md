# **PG Room Finder Desktop Application**  

## **Introduction**  
The **PG Room Finder Application** is a **Java-based** solution designed to **simplify** the search and booking process for **paying guest (PG) accommodations**. It features an interactive **user interface**, integrates with a **MySQL database**, and offers **real-time search functionality** to deliver **accurate availability results**.  

## **Features**  
Efficient management of listings and user data via MySQL.  
Interactive, user-friendly interface for a seamless experience.  
Real-time search functionality for accurate availability results.  
Focus on **performance, security, and maintainability**.  

## **Technology Stack**  
- **Language**: Java  
- **Database**: MySQL  
- **Backend Framework**: JDBC (Java Database Connectivity)  
- **IDE Recommended**: IntelliJ IDEA / Eclipse / NetBeans  

## **Installation & Setup**  

### **Prerequisites**  
Ensure you have the following installed:  
- **Java Development Kit (JDK) 8 or later**  
- **MySQL Database Server**  
- **MySQL Connector/J (JDBC Driver)**  
- **An IDE (IntelliJ, Eclipse, NetBeans, or VS Code)**  

### **Steps to Install**  

1️⃣ **Clone the Repository**  
```bash
git clone https://github.com/ghavate-n11/pg-room-finder.git
```  

2️⃣ **Set Up the MySQL Database**  
- Open **phpMyAdmin** or **MySQL Workbench**.  
- Create a new database:  
  ```sql
  CREATE DATABASE pg_room_finder;
  ```
- Import the provided `database.sql` file into MySQL.  

3️⃣ **Configure Database Connection in Java**  
- Open the `config.properties` file or update the **JDBC connection settings** in `DatabaseConnection.java`:  
```java
String url = "jdbc:mysql://localhost:3306/pg_room_finder";
String user = "root";
String password = "";
Connection conn = DriverManager.getConnection(url, user, password);
```  

4️⃣ **Run the Application**  
- Open the project in your preferred **IDE**.  
- Compile and run the **Main.java** file.  

## **Usage**  
**User Module**:  
- Users can **search** for PG accommodations.  
- Users can **view details** and book available rooms.  

 **Admin Module**:  
- Admins can **add, update, and remove** room listings.  
- Admins can **manage user data and bookings**.  

## **Future Enhancements**  
Implement a **GUI-based version** using JavaFX or Swing.  
Add **Google Maps API** integration for location-based searching.  
Enable **online payment integration**.  

## **License**  
This project is **open-source** under the **MIT License**.  

## **Contributing**  
Contributions are **welcome**! If you find any issues or want to improve the system, feel free to **fork the repository** and submit a **pull request**.  

## **Contact**  
**Email**: [nileshghavate11@gmail.com](mailto:nileshghavate11@gmail.com)  
**LinkedIn**: [linkedin.com/in/nileshghavate-203b27251](https://linkedin.com/in/nileshghavate-203b27251)  

### **🏠 Happy Room Hunting! 🏡**  
