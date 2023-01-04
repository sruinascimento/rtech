package main.java.br.com.rtech.main;

import main.java.br.com.rtech.model.Category;
import main.java.br.com.rtech.model.Course;
import main.java.br.com.rtech.model.SubCategory;
import main.java.br.com.rtech.service.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Category> categories = CreateCategoryService.generateObjectCategory("src/main/resources/planilha-dados-escola - Categoria.csv");
        Map<String, Category> categoriesByCode = new HashMap<>();
        for (Category category : categories) {
            categoriesByCode.put(category.getCode(), category);
        }

        List<SubCategory> subCategories = CreateSubCategoryService.generateObjecSubCategory("src/main/resources/planilha-dados-escola - Subcategoria.csv", categoriesByCode);
        //ordenando pela ordem
        subCategories.sort(Comparator.comparing(SubCategory::getOrder));

        Map<String, SubCategory> subcategoriesByCode = new HashMap<>();
        for (SubCategory subCategory : subCategories) {
            subcategoriesByCode.put(subCategory.getCode(), subCategory);
        }

        List<Course> courses = CreateCourseService.generateObjectCourse("src/main/resources/planilha-dados-escola - Curso.csv", subcategoriesByCode);
        HTMLCategoryPageGeneratorService.generateCategoryPage(categories, courses, subCategories);

        System.out.println("Subcateries hasn't description");
        UtilityMethodService.getSubcategoriesHasntDescription(subCategories).forEach(System.out::println);
        System.out.println("Active Categories");
        UtilityMethodService.getActiveCategories(categories).forEach(System.out::println);
        System.out.println("Any private course? " + UtilityMethodService.isAnyPrivateCourse(courses));
        System.out.println("Instructor's name");
        UtilityMethodService.getUniqueInstructrorsName(courses).forEach(System.out::println);
        System.out.println("Total active subcategories with description = " + UtilityMethodService.getTotalActiveSubcategoriesWithDescription(subCategories));
        System.out.println("Instructors and total courses");
        UtilityMethodService.getInstructorsAndYoursTotalOfCourse(courses).forEach((name, total) -> System.out.println(name + " -> " + total));

    }
}
