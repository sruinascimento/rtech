package br.com.rtech.service;

import br.com.rtech.model.Course;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLCoursePageGeneratorService {
    public static void generateCoursePage(int id, String courseName, int estimatedTimeCourseCompletion, int idSubcategory, String subcategoryName) {
        try (FileWriter fileWriter = new FileWriter("course.html")) {
            fileWriter.write("<p>" + id +"</p>");
            fileWriter.write("<p>" + courseName +"</p>");
            fileWriter.write("<p>" + estimatedTimeCourseCompletion +"</p>");
            fileWriter.write("<p>" + idSubcategory +"</p>");
            fileWriter.write("<p>" + subcategoryName +"</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
