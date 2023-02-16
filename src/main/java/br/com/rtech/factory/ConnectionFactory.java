package br.com.rtech.factory;

import javax.sql.DataSource;

import br.com.rtech.service.LoadDataDBConfigurationService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;
import java.util.Map;

public class ConnectionFactory {
    private  DataSource dataSource;
    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Map<String, String> dataToAccessDB = LoadDataDBConfigurationService.getDataToAccessDB();
        comboPooledDataSource.setJdbcUrl(dataToAccessDB.get("URL"));
        comboPooledDataSource.setUser(dataToAccessDB.get("ROOT"));
        comboPooledDataSource.setPassword(dataToAccessDB.get("PASSWD"));
        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

