package br.com.rtech.main;

import br.com.rtech.dao.CourseDAO;
import br.com.rtech.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUpdateCourseVisibility {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            var courseDao = new CourseDAO(connection);
            courseDao.updateCoursePrivateVisibilityToPublicVisibility();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
