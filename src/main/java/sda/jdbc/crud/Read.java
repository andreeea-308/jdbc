package sda.jdbc.crud;

import java.sql.*;
import java.time.LocalDate;

public class Read {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/sda-jdbc-67";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3182";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()){
                //count++;
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                Date createdDate = resultSet.getDate(5);
                System.out.println("Student id = " + id + " First Name = " + firstName +
                        " Last name = " + lastName + " Age = " + age + " Date = " + createdDate);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }

    }
    /** [first]
     *
     * Declare 3 constants (private final static) that holds data necessary for database connection:
     *  - db_host: "jdbc:mysql://localhost:3306/sda-jdbc-##"
     *  - db_username
     *  - db_password
     */

    /**
     * Steps to read from DB:
     * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
     * 2. From connection obtained, get a Statement object using static method 'createStatement'
     * 3. On statement object, execute a query for selecting all students. As result, we'll have a ResultSet instance
     * 4. On resultSet instance, use a 'while' command to move the cursor forward one row
     * 5. In 'while' block, on resultSet object, use appropriate methods (ex. getInt, getString etc.) to extract data
     and assign these data to variables. Use column names as methods parameter
     * 6. Now your variables holds data from database. Print this data to console.
     * 7. Cleanup environment - close all your resources (resultSet, statement, connection)
     *
     *
     * Great job! You successfully fetch data from database using Java.
     * Let insert some data in db. But first, what about 'executeUpdate' method on Statement interface?
     */
}
