package br.com.rtech.main;

import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;
import br.com.rtech.service.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Category> categories = CreateCategoryService.generateObjectCategory("files/planilha-dados-escola - Categoria.csv");
        List<SubCategory> subCategories = CreateSubCategoryService.generateObjecSubCategory("files/planilha-dados-escola - Subcategoria.csv");
        //ordenando pela ordem
        subCategories.sort(Comparator.comparing(SubCategory::getOrder));
        List<Course> courses = CreateCourseService.generateObjectCourse("files/planilha-dados-escola - Curso.csv", subCategories);
        HTMLCategoryPageGeneratorService.generateCategoryPage(categories, courses, subCategories);

//      categories.forEach(System.out::println);
//        categories.stream().filter(category -> !category.isActive()).forEach(System.out::println);


//        ExtractorAtributesService.getAtributes("files/planilha-dados-escola - Categoria.csv");
//        CreateSubCategoryService.generateObjecSubCategory("files/planilha-dados-escola - Subcategoria.csv");


    }
}
