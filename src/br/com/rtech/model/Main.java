package br.com.rtech.model;

import br.com.rtech.service.CreateCategoryService;
import br.com.rtech.service.CreateCourseService;
import br.com.rtech.service.CreateSubCategoryService;
import br.com.rtech.service.HTMLCategoryPageGeneratorService;

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



    }
}
