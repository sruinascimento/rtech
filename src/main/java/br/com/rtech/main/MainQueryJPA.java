package br.com.rtech.main;

import br.com.rtech.dao.CategoryDao;

import br.com.rtech.dao.SubCategoryDao;
import br.com.rtech.model.Instructor;
import br.com.rtech.model.SubCategory;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainQueryJPA {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(entityManager);
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);

        entityManager.getTransaction().begin();
        System.out.println(entityManager.find(SubCategory.class, 1l));
//        categoryDao.getCategories().stream()
//                .forEach(System.out::println);

//        subCategoryDao.getSubcategories().stream()
//                .forEach(System.out::println);
//        CategoryInformation category = entityManager.find(Category.class, 1l);
//        CategoryInformation subcategory = entityManager.find(SubCategory.class, 1l);
//        System.out.println(subcategory);
        entityManager.close();
    }
}
