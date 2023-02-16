package br.com.rtech.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoadDataDBConfigurationService {

    public static Map<String, String> getDataToAccessDB() {
        Map<String, String> dataConfigureDB = new HashMap<>();
        Properties properties = loadFileConfiguration();
        dataConfigureDB.put("ROOT", properties.getProperty("ROOT"));
        dataConfigureDB.put("PASSWD", properties.getProperty("PASSWD"));
        dataConfigureDB.put("URL", properties.getProperty("URL"));
        return dataConfigureDB;
    }

    private static Properties loadFileConfiguration() {
        String path = "/home/rui/IdeaProjects/rtech/src/main/resources/.properties";
        try (InputStream inputStream =  new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
