package br.com.rtech.main;

import br.com.rtech.dao.CourseDao;
import br.com.rtech.model.Course;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainUpdateCourseVisibilityJPA {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();

        System.out.println("Cursos privados");
        courseDao.updateCoursesPrivateToPublic();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
