package br.com.rtech.main;

import br.com.rtech.dao.CategoryDao;
import br.com.rtech.dao.CourseDao;
import br.com.rtech.dao.SubCategoryDao;
import br.com.rtech.model.Category;
import br.com.rtech.model.Course;
import br.com.rtech.model.SubCategory;
import br.com.rtech.service.HTMLCategoryPageGeneratorService;
import br.com.rtech.service.HTMLReportGeneratorService;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MainReportJPA {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();

        List<Category> activeCategories = categoryDao.getActiveCategories();
        List<SubCategory> activeSubcategories = subCategoryDao.geActivetSubcategories();
        List<Course> publicCourses = courseDao.getPublicCourses();
        List<String> namesOfSubcategoriesHasntDescription = subCategoryDao.getNameOfSubcategoriesHasntDescription();
//        System.out.println(activeCategories);
        HTMLReportGeneratorService.generateReportPage(activeCategories, activeSubcategories, publicCourses, namesOfSubcategoriesHasntDescription);


        entityManager.close();
    }
}
