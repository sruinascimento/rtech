package br.com.rtech.main;

import br.com.rtech.dao.CourseDao;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainDeleteCourseJPA {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();

        Long id = courseDao.delete("python-fastapi");

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Id deleted course: " + id);
    }
}
