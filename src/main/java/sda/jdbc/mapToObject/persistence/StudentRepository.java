package sda.jdbc.mapToObject.persistence;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import sda.jdbc.mapToObject.model.Student;

import java.sql.*;
import java.util.Optional;

public class StudentRepository {
    public Optional<Student> findById(int id) {
        Connection connection = DatabaseUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToStudent(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Student> mapToStudent(ResultSet resultSet) {
        try {
            int count = 0;
            int rowsFetched = ((ResultSetImpl) resultSet).getRows().size();
            if (rowsFetched == 1) {
                resultSet.next();
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                Date createdDate = resultSet.getDate(5);
                return Optional.of(new Student(id, firstName, lastName, age, createdDate));
            } else if (rowsFetched > 1) {
                throw new RuntimeException("Not unique result");
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
