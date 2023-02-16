package br.com.rtech.main;

import br.com.rtech.factory.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDeleteCourse {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        String sql = "DELETE FROM course WHERE id = ?";
        try (PreparedStatement preparedStatement = connectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, 7);
            preparedStatement.execute();
            int lineModifieds = preparedStatement.getUpdateCount();
            System.out.println("Register deleted = " + lineModifieds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
