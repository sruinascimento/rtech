package br.com.rtech.service;

import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateCourseService {
    public static List<Course> generateObjectCourse(String path, Map<String, SubCategory> subCategories) {
        List<Course> courses = new ArrayList<>();
        List<String[]> courseAtributes = ExtractorAtributesService.getAtributes(path);

        for (String[] atributes : courseAtributes) {
            try {
                String name = atributes[0];
                String code = atributes[1];
                int estimatedTimeCourseCompletion = Integer.parseInt(atributes[2]);
                String visibility = atributes[3];
                String targetPublic = atributes[4];
                String instructorsName = atributes[5];
                String syllabus = atributes[6];
                String skills = atributes[7];
                String subcategoryCode = atributes[8];
                SubCategory subCategory = subCategories.get(subcategoryCode);
                if (subCategory == null) throw new RuntimeException("Invalid subcategory: " + subcategoryCode);
                Course course = new Course(name, code, estimatedTimeCourseCompletion, instructorsName);
                if (visibility.equals("PÚBLICA")) course.setPrivateVisibility(false);
                if (visibility.equals("PRIVADA")) course.setPrivateVisibility(true);
                course.setTargetPublic(targetPublic);
                course.setSyllabus(syllabus);
                course.setDevelopedSkills(skills);
                course.setSubCategory(subCategory);
                courses.add(course);
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new RuntimeException(exception);
            }
        }
        return courses;
    }
}
