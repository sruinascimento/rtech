package br.com.rtech.service;

import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .anyMatch(Course::isPublicVisibility);
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
        return courses.stream()
                .collect(Collectors.groupingBy(course -> course.getInstructor().getName(), Collectors.counting()));
    }
}
