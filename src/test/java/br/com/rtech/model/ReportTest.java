package br.com.rtech.model;

import br.com.rtech.dao.CategoryDao;
import br.com.rtech.dao.CourseDao;
import br.com.rtech.dao.SubCategoryDao;
import br.com.rtech.util.JPAUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {
    private CourseDao courseDao;
    private CategoryDao categoryDao;
    private SubCategoryDao subCategoryDao;
    private EntityManager entityManager;

    @BeforeEach
    public void initializeDaoAtributes() {
        this.entityManager = JPAUtil.getEntityManager();
        this.courseDao = new CourseDao(entityManager);
        this.categoryDao = new CategoryDao(entityManager);
        this.subCategoryDao = new SubCategoryDao(entityManager);
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    public void realizeRoolbackAndFinalizeTransactions () {
        this.entityManager.getTransaction().rollback();
        this.entityManager.close();
    }

    @Test
    public void testGetActiveCategories() {
        List<Category> activeCategories = categoryDao.getActiveCategories();
        assertFalse(activeCategories.isEmpty());
        boolean allActiveCategory =  activeCategories.stream()
                        .allMatch(Category::isActive);
        assertTrue(allActiveCategory);
    }

    @Test
    public void testGetActiveSubcategory() {
        List<SubCategory> activetSubcategories = subCategoryDao.geActivetSubcategories();
        assertFalse(activetSubcategories.isEmpty());
        boolean allActiveSubcategory = activetSubcategories.stream()
                .allMatch(SubCategory::isActive);
        assertTrue(allActiveSubcategory);

    }

    @Test
    public void testGetPublicCourses() {
        List<Course> publicCourses = courseDao.getPublicCourses();
        assertFalse(publicCourses.isEmpty());

        boolean allPublicCourse = publicCourses.stream()
                .allMatch(Course::isPublicVisibility);

        assertTrue(allPublicCourse);
    }

    @Test
    public void testGetCategoryHasntDescription() {
        List<String> namesOfSubcategoriesHasntDescription = subCategoryDao.getNameOfSubcategoriesHasntDescription();
        assertNotNull(namesOfSubcategoriesHasntDescription);
    }
}
