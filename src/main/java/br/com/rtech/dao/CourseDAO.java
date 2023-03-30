package br.com.rtech.dao;

import br.com.rtech.model.Course;
import br.com.rtech.model.CourseVisibility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public void save(Course course) {
        String sqlInstructor = "INSERT INTO instructor (name_instructor) VALUES (?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInstructor, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, course.getInstructor());
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("Id do instrutor gerado " + id);
                    String sql = "INSERT INTO course (name_course, code_course, estimated_time_course_completion, public_visibility, id_instructor)" +
                            " VALUES ( ?, ?, ?, ?, ?);";
                    try (PreparedStatement preparedStatement1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        preparedStatement1.setString(1, course.getName());
                        preparedStatement1.setString(2, course.getCode());
                        preparedStatement1.setInt(3, course.getEstimatedTimeCourseCompletion());
                        preparedStatement1.setString(4, course.getVisibility().toString());
                        preparedStatement1.setInt(5, id);

                        preparedStatement1.execute();

                        try (ResultSet resultSet1 = preparedStatement1.getGeneratedKeys()) {
                            while (resultSet1.next()) {
                                System.out.println("Id do curso " + resultSet1.getInt(1));
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateCoursePrivateVisibilityToPublicVisibility() {
        String sql = "UPDATE course c SET c.public_visibility = ? WHERE c.public_visibility = ? ";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, CourseVisibility.PUBLICA.toString());
            preparedStatement.setString(2,  CourseVisibility.PRIVADA.toString());
            preparedStatement.execute();
            int linesUpdateds = preparedStatement.getUpdateCount();
            System.out.println("Register updated: " + linesUpdateds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String code) {
        String sql = "DELETE FROM course WHERE code_course = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, code);
            preparedStatement.execute();
            int lineModifieds = preparedStatement.getUpdateCount();
            System.out.println("Register deleted = " + lineModifieds);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> getReportPublicCourse() {
        List<String[]> coursesPublic = new ArrayList<>();
        // TODO: usar text blocks
        String sql = """
                        SELECT c.id, c.name_course, c.estimated_time_course_completion, c.id_subcategory, ci.name_category  
                        FROM course c INNER JOIN subcategory s  ON s.id = c.id_subcategory  
                        INNER JOIN category_information ci ON ci.id = s.id_category_information  
                        WHERE c.public_visibility = ?;
                """;


        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, CourseVisibility.PUBLICA.toString());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()) {
                    int courseId = resultSet.getInt(1);
                    String courseName = resultSet.getString(2);
                    int estimatedTimeCourseCompletion = resultSet.getInt(3);
                    int subcategoryId = resultSet.getInt(4);
                    String subcategoryName = resultSet.getString(5);

                    String[] dataPublicCourses = {String.valueOf(courseId), courseName, String.valueOf(estimatedTimeCourseCompletion), String.valueOf(subcategoryId), subcategoryName};

                    coursesPublic.add(dataPublicCourses);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coursesPublic;
    }


}
