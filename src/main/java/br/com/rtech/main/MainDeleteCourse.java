package br.com.rtech.main;

import br.com.rtech.dao.CourseDAO;
import br.com.rtech.factory.ConnectionFactory;

import java.sql.*;

public class MainDeleteCourse {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            var courseDao = new CourseDAO(connection);
            courseDao.delete(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
