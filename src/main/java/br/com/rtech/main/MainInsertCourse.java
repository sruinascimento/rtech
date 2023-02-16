package br.com.rtech.main;

import br.com.rtech.factory.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainInsertCourse {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        String sqlInstructor = "INSERT INTO instructor (name_instructor) VALUES (?);";

        try (PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(sqlInstructor, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "Kilua");
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("Id do instrutor gerado " + id);
                    String sql = "INSERT INTO course (name_course, code_course, estimated_time_course_completion, public_visibility, id_instructor)" +
                            " VALUES ( ?, ?, ?, ?, ?);";
                    try (PreparedStatement preparedStatement1 = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        preparedStatement1.setString(1, "Java 9");
                        preparedStatement1.setString(2, "java-9");
                        preparedStatement1.setInt(3, 10);
                        preparedStatement1.setString(4, "PÚBLICA");
                        preparedStatement1.setInt(5, id);

                        preparedStatement1.execute();

                        try (ResultSet resultSet1 = preparedStatement1.getGeneratedKeys()) {
                            while (resultSet1.next()) {
                                System.out.println("Id do curso " + resultSet1.getInt(1));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
