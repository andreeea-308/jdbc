package sda.jdbc.crud;

import java.sql.*;

public class Delete {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/sda-jdbc-67";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3182";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            int rowsDeleted = statement.executeUpdate("delete from students where first_name =  'Andrei'");
            System.out.println("Deleted rows = " + rowsDeleted);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }

    }

    /**
     * Declare 3 constants (private final static) that holds data necessary for database connection:
     *  - db_host: "jdbc:mysql://localhost:3306/sda-jdbc-##"
     *  - db_username
     *  - db_password
     */


    /**
     * Steps to delete a row in DB:
     * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
     * 2. From connection obtained, get a Statement object
     * 3. For deleting a row from table, we'll use 'executeUpdate' method that returns an integer which represent number of affected rows
     * 4. Print a message to console and highlight how many rows has been updated
     * 5. Cleanup environment - close all your resources (statement, connection)
     *
     * Very nice! Last operation you should do is update.
     */
}
