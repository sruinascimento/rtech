package br.com.rtech.main;

import br.com.rtech.dao.CourseDAO;
import br.com.rtech.factory.ConnectionFactory;
import br.com.rtech.service.HTMLCoursePageGeneratorService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MainReport {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
            var courseDao = new CourseDAO(connection);
            List<String[]> courses = courseDao.getReportPublicCourse();
            HTMLCoursePageGeneratorService.generateCoursePage(courses);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
