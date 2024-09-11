package sda.jdbc.crud;

import java.sql.*;

public class Update {
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
            resultSet = statement.executeQuery("select * from students where id = 1");
            printToConsol(resultSet);
            int rowsUpdated = statement.executeUpdate("update students set first_name = 'John' where id = 1");
            System.out.println("Updated rows = " + rowsUpdated);
            resultSet = statement.executeQuery("select * from students where id = 1");
            printToConsol(resultSet);
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
    public static void printToConsol(ResultSet resultSet){
        try {
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                Date createdDate = resultSet.getDate(5);
                System.out.println("Student id = " + id + " First Name = " + firstName +
                        " Last name = " + lastName + " Age = " + age + " Date = " + createdDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
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
     * Steps to update row in DB:
     * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
     * 2. From connection obtained, get a Statement object that we'll use for all database interactions
     * 3. Execute a query for selecting a student with specific id (ex. id = 1) and print data to console
     * 4. Using the same statement object, execute another query to update this student first_name
     * 4.1 For update, we'll use 'executeUpdate' method that returns an integer which represent number of effected rows
     * 4.2 Print a message to console and highlight how many rows has been updated
     * 5. Now execute the same select query and check if the result is different from the first try
     * 6. Cleanup environment - close all your resources (result sets, statement, connection)


     *  Great job! You successfully applied CRUD operations on database. But you only used hardcoded and fixed SQL statements.
     *  What if you want to execute parameterized statements?
     *  Maybe PreparedStatement interface can help you to achieve this.
     */
}
