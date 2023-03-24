package br.com.rtech.main;

import br.com.rtech.dao.CourseDao;
import br.com.rtech.dao.InstructorDao;
import br.com.rtech.model.Course;
import br.com.rtech.model.Instructor;
import br.com.rtech.util.JPAUtil;

import javax.persistence.EntityManager;

public class MainInsertCourseJPA {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        CourseDao courseDAO = new CourseDao(entityManager);
        InstructorDao instructorDao = new InstructorDao(entityManager);

        Instructor instructor = new Instructor("Nico Steppat");
        Course course = new Course("Python FastAPI", "python-fastapi", 12, instructor);
        course.setVisibility("PÚBLICA");
        entityManager.getTransaction().begin();

        instructorDao.save(instructor);
        courseDAO.save(course);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("ID generated " + course.getId());
    }
}
