package br.com.rtech.main;

import br.com.rtech.factory.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUpdateCourse {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        String sql = "UPDATE course c SET c.public_visibility = ? WHERE c.public_visibility = ? ";
        try (PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "PÚBLICA");
            preparedStatement.setString(2, "PRIVADA");
            preparedStatement.execute();
            int linesUpdateds = preparedStatement.getUpdateCount();
            System.out.println("Lines updateds: " + linesUpdateds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
