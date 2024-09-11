package sda.jdbc.crud;

import java.sql.*;

public class Create {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/sda-jdbc-67";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3182";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("insert into students(first_name, last_name, age, created_date) " +
                    "values('Andreea', 'Grecu', 24, current_date()), ('Mihai', 'Eminescu', 19, current_date())");
            System.out.println("Rows affected = " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }


/**
 * Declare 3 constants (private final static) that holds data necessary for database connection:
 * - db_host: "jdbc:mysql://localhost:3306/sda-jdbc-##"
 * - db_username
 * - db_password
 * <p>
 * Steps to insert rows in DB:
 * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
 * 2. From connection obtained, get a Statement object
 * 3. Execute a query for inserting 2 students. We'll use 'executeUpdate' method. As result, we'll have an integer
 (representing number of affected rows)
 * 4. Assign this number to a variable
 * 5. Print a message to console and highlight how many rows has been inserted
 * 6. Cleanup environment - close all your resources (statement, connection)
 * <p>
 * Great work! Next you will learn how to remove rows from db tables.
 */

/**
 * Steps to insert rows in DB:
 * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
 * 2. From connection obtained, get a Statement object
 * 3. Execute a query for inserting 2 students. We'll use 'executeUpdate' method. As result, we'll have an integer
 (representing number of affected rows)
 * 4. Assign this number to a variable
 * 5. Print a message to console and highlight how many rows has been inserted
 * 6. Cleanup environment - close all your resources (statement, connection)
 *
 * Great work! Next you will learn how to remove rows from db tables.
 */
}
