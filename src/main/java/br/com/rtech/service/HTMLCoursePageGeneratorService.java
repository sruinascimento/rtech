package br.com.rtech.service;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLCoursePageGeneratorService {
    public static void generateCoursePage(List<String[]> courses) {
        try (FileWriter fileWriter = new FileWriter("course.html")) {

            for (String[] course : courses) {
                fileWriter.write("<p>" + course[0] +"</p>");
                fileWriter.write("<p>" + course[1] +"</p>");
                fileWriter.write("<p>" + course[2] +"</p>");
                fileWriter.write("<p>" + course[3] +"</p>");
                fileWriter.write("<p>" + course[4] +"</p>");
            }
            System.out.println("course.html created. Sucess \u2705");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("course.html was not created. Failed \u274C");
        }
    }

}
