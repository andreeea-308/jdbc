package sda.jdbc.mapToObject;

import sda.jdbc.mapToObject.model.Student;
import sda.jdbc.mapToObject.persistence.StudentRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Optional<Student> studentOptional = studentRepository.findById(30);
        if (studentOptional.isPresent()){
            System.out.println(studentOptional.get());
        } else {
            System.out.println("Student not found!!!");
        }
    }
    /**
     * 1. Create 2 packages with names model and persistence

     * 2. In 'model' package create a class Student. For each column in students table, declare a corresponding variable in Student class

     * 3. In 'persistence' package create DatabaseUtils class
     * 3.1 In DatabaseUtils declare 3 constants (private final static) that holds data necessary for database connection:
        - db_host: "jdbc:mysql://localhost:3306/sda-jdbc-##"
        - db_username
        - db_password
     *  3.2 In DatabaseUtils create a static method that returns an instance of Connection

     * 4. In 'persistence' package create StudentRepository class
     * 4.1 In StudentRepository:
        - create a method called 'findById' that accepts a parameter of type int and returns an object of type Student
        - get a database connection using DatabaseUtils class
        - get a prepared statement from connection, and execute a select query that fetch a row from students table by id
        - on preparedStatement, set method input as query parameter
        - create a Student instance
        - iterate over ResultSet and map data from row to corresponding field of student object
        - return student instance

     * 5. In this class, in main method, create StudentRepository object and get a student with specific id from database.
     * 6. Print student to console

     * Great! You successfully map a row from database to a Java object. Maybe Hibernate can help you to do this easily.
     */
}
