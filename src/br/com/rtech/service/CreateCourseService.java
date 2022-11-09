package br.com.rtech.service;

import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCourseService {
    public static List<Course> generateObjectCourse(String path, List<SubCategory> subCategories) {
        List<Course> courses = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(path))) {
            // skip the labels
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] atributesCourse = scanner.nextLine().split(",");
                String name = atributesCourse[0];
                String code = atributesCourse[1];
                int estimatedTimeCourseCompletion = Integer.parseInt(atributesCourse[2]);
                String visibility = atributesCourse[3];
                String targetPublic = atributesCourse[4];
                String instructorsName = atributesCourse[5];
                String syllabus = atributesCourse[6];
                String skills = atributesCourse[7];
                String subcategoryCode = atributesCourse[8];
                for (SubCategory subCategory: subCategories) {
                    try {
                        if (subcategoryCode.equals(subCategory.getCode())) {
                            Course course = new Course(name, code, estimatedTimeCourseCompletion, instructorsName);
                            if (visibility.equals("PÚBLICA")) course.setPrivateVisibility(false);
                            if (visibility.equals("PRIVADA")) course.setPrivateVisibility(true);
                            course.setTargetPublic(targetPublic);
                            course.setSyllabus(syllabus);
                            course.setDevelopedSkills(skills);
                            course.setSubCategory(subCategory);
                            courses.add(course);
                        }
                    } catch (IllegalArgumentException ignored) {
                    }

                }
            }

        } catch (FileNotFoundException | NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
        }
        return  courses;
    }
}
