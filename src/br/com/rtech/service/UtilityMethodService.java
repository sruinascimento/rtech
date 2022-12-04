package br.com.rtech.service;

import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilityMethodService {

    public static List<SubCategory> getSubcategoriesHasntDescription(List<SubCategory> subCategories) {
        return subCategories.stream()
                .filter(subCategory -> subCategory.getDescription().equals(""))
                .toList();
    }

    public static List<Category> getActiveCategories(List<Category> categories) {
        return categories.stream()
                .filter(Category::isActive)
                .toList();
    }

    public static boolean isAnyPrivateCourse(List<Course> courses) {
        return courses.stream()
                .anyMatch(Course::isPrivateVisibility);
    }

    public static List<String> getUniqueInstructrorsName(List<Course> courses) {
        return courses.stream()
                .map(course -> course.getInstructor().getName())
                .distinct()
                .toList();
    }

    public static long getTotalActiveSubcategoriesWithDescription(List<SubCategory> subCategories) {
        return subCategories.stream()
                .filter(subCategory -> subCategory.isActive() && !subCategory.getDescription().equals(""))
                .count();
    }

    public static Map<String, Long> getInstructorsAndYoursTotalOfCourse(List<Course> courses) {

        List<String> instructorsName = getUniqueInstructrorsName(courses);
        Map<String, Long> totalCoursesByInstructor = new HashMap<>();
        for (String name : instructorsName) {
            long totalCourses = courses.stream()
                    .filter(course -> course.getInstructor().getName().equals(name))
                    .count();
            totalCoursesByInstructor.put(name, totalCourses);
        }

        return totalCoursesByInstructor;
    }
}
