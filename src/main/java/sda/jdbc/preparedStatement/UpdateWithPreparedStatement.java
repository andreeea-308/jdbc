package sda.jdbc.preparedStatement;

import java.sql.*;

public class UpdateWithPreparedStatement {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/sda-jdbc-67";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3182";

    public static void main(String[] args) {
        int idToUpdate = 5;
        String newFirstName = "Mirel";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementForUpdate = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("select * from students where id = ?");
            preparedStatement.setInt(1, idToUpdate);
            resultSet = preparedStatement.executeQuery();
            printToConsol(resultSet);

            preparedStatementForUpdate = connection.prepareStatement("update students set first_name = ? where id = ?");
            preparedStatementForUpdate.setString(1, newFirstName);
            preparedStatementForUpdate.setInt(2, idToUpdate);

            int rowsUpdated = preparedStatementForUpdate.executeUpdate();
            System.out.println("Updated rows = " + rowsUpdated);

            resultSet = preparedStatement.executeQuery();
            printToConsol(resultSet);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                preparedStatementForUpdate.close();
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
     * Steps to use PreparedStatement:
     * 1. Get a Connection object using DriverManager's static method 'getConnection' and variables declared and initialized above
     * 2. From connection obtained, get a PreparedStatement object using method 'preparedStatement'
     * 2.1 In sql query, replace hardcoded values with "?", that marks an expected parameter
     * 3. On preparedStatement object set appropriate values for each expected parameter - "?" (ex. setInt, setString etc.)
     * 4. After setting all parameters, call on prepared statement method 'executeQuery' for select or 'executeUpdate'
     for update, delete, insert

     * Do above steps for:
     * - reading a row from table with a specific id and print rows data
     * - updating the same row
     * - reading again the same row and check for differences

     * Cleanup environment - close all your resources (result sets, statement, connection)


     * Great job! You just wrote code that can be used to fetch any student from db by their id. Remember, avoid hardcoding sql queries!
     * What about structuring our code to make it reusable and respect Single Responsibility principle?
     */
}
