package br.com.rtech.main;

import br.com.rtech.dao.CourseDAO;
import br.com.rtech.factory.ConnectionFactory;
import br.com.rtech.model.Course;

import java.sql.*;

public class MainInsertCourse {
    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            var courseDao = new CourseDAO(connection);
            Course course = new Course("Python POO", "python-poo", 20, "Aquiles");
            courseDao.save(course);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
