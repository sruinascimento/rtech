package br.com.rtech.main;

import br.com.rtech.factory.ConnectionFactory;
import br.com.rtech.service.HTMLCoursePageGeneratorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainQueryCourse {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        String sql = """ 
                    SELECT c.id, c.name_course, c.code_course, c.estimated_time_course_completion, c.public_visibility, c.target_public, i.name_instructor, c.syllabus, 
                    c.developed_skill, ci.code_category, s.id , ci.name_category FROM course c
                    INNER JOIN instructor i 
                    ON c.id_instructor = i.id 
                    INNER JOIN subcategory s 
                    ON s.id = c.id_subcategory 
                    INNER JOIN category_information ci 
                    ON ci.id = s.id_category_information 
                    WHERE c.public_visibility = ?;
                """;

        try (PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "PÚBLICA");
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    int courseId = resultSet.getInt(1);
                    String courseName = resultSet.getString(2);
                    int estimatedTimeCourseConclusion = resultSet.getInt(4);
                    int subcategoryId = resultSet.getInt(11);
                    String subcategoryName = resultSet.getString(12);
                    System.out.println("Course id " + courseId);
                    System.out.println("Course name " + courseName);
                    System.out.println("Estimated time course to conclusion " + estimatedTimeCourseConclusion);
                    System.out.println("Subcategory id " + subcategoryId);
                    System.out.println("Subcategory name " + subcategoryName);
                    //TODO: adicionar uma lista com todos os objetos para o service abaixo
                    HTMLCoursePageGeneratorService.generateCoursePage(courseId, courseName, estimatedTimeCourseConclusion, subcategoryId, subcategoryName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
