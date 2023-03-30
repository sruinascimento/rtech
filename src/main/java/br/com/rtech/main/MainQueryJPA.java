package br.com.rtech.main;

import br.com.rtech.dao.CategoryDao;

import br.com.rtech.dao.SubCategoryDao;
import br.com.rtech.model.Category;
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
        categoryDao.getActiveCategories().stream()
                .forEach(System.out::println);

        subCategoryDao.getActivetSubcategories().stream()
                .forEach(System.out::println);

        Category category = entityManager.find(Category.class, 1l);
        SubCategory subcategory = entityManager.find(SubCategory.class, 1l);
        System.out.println(subcategory);
        entityManager.close();
    }
}
