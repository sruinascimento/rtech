package br.com.rtech.main;

import br.com.rtech.factory.ConnectionFactory;

import java.sql.*;

public class MainAdvancedSQL {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.getConnection()) {
//            getNameAndOrderOfSubcategoriesHasCourse(connection);
            getNameAndAmountOfInstructorHasMoreCourses(connection);
           // getCategoryNameAndAmountoOfCoursesAndAmountHoursToConclusion(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void getNameAndOrderOfSubcategoriesHasCourse(Connection connection) {
        String sql = """ 
                        SELECT DISTINCT  ci.name_category, ci.order_category  FROM category_information ci 
                        INNER JOIN  subcategory s 
                        ON ci.id = s.id_category_information 
                        INNER JOIN course c 
                        ON c.id_subcategory = s.id 
                        WHERE ci.is_active = ? 
                        ORDER BY ci.order_category, ci.name_category;
                        
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, "ATIVA");
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                System.out.println("Name and order subcategory actives has any course and ordely");
                while (resultSet.next()) {
                    String subcategoryName = resultSet.getString(1);
                    int subcategoryOrder = resultSet.getInt(2);
                    System.out.printf("Subcategory name: %s, order: %d%n",  subcategoryName, subcategoryOrder);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void getNameAndAmountOfInstructorHasMoreCourses(Connection connection) {
        String sql = """ 
                        SELECT i.name_instructor, COUNT(i.name_instructor) AS total_of_courses FROM instructor i
                        INNER JOIN course c ON c.id_instructor = i.id
                        GROUP BY name_instructor
                        ORDER BY total_of_courses DESC, i.name_instructor  
                        LIMIT 1;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                System.out.println("Name and amount of instructor has more courses");
                while (resultSet.next()) {
                    String instructorsName = resultSet.getString(1);
                    int amount = resultSet.getInt(2);
                    System.out.printf("Instructors name: %s, amount: %d%n",  instructorsName, amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getCategoryNameAndAmountoOfCoursesAndAmountHoursToConclusion(Connection connection) {
        String sql = """ 
                       SELECT ci.name_category, COUNT(c.id_subcategory) AS total_courses, 	SUM(c.estimated_time_course_completion) as total_hours_conclusion_course  
                       FROM subcategory s
                       INNER JOIN course c ON c.id_subcategory = s.id
                       INNER JOIN category_information ci ON s.id_category = ci.id
                       WHERE ci.is_active IN (?)
                       GROUP BY ci.name_category ;     
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, "ATIVA");
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                System.out.println("Category name, total course and total time to conclusion");
                while (resultSet.next()) {
                    String categoryName = resultSet.getString(1);
                    int totalCourses = resultSet.getInt(2);
                    int totalTimeForConclusion = resultSet.getInt(3);
                    System.out.printf("Category name: %s, total courses: %d, total time to conclusion: %d%n",  categoryName, totalCourses, totalTimeForConclusion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
