package org.example.hosdemo;
import java.sql.*;
public class DBconnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String dbName = "Appointmentdb";
        String dbUser = "root";
        String dbpassword = "passroot";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, dbUser, dbpassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
