package sda.jdbc.mapToObject.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/sda-jdbc-67";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3182";
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Exception while getting connection");
        }
    }
}
