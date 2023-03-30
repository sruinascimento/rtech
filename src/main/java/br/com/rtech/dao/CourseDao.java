package br.com.rtech.dao;

import br.com.rtech.model.Course;
import br.com.rtech.model.CourseVisibility;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class CourseDao {

    private EntityManager entityManager;

    public CourseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Course course) {
        this.entityManager.persist(course);
    }

    public Long delete(String code) {
        final Long notDeletedCourse = -1L;
        Course course = getCourseByCode(code);
        if (course != null) {
            this.entityManager.merge(course);
            this.entityManager.remove(course);
            return course.getId();
        }

        return notDeletedCourse;
    }

    public Course getCourseByCode(String code) {
        try {
            String jpql = "SELECT c FROM Course c WHERE c.code = :code";
            return this.entityManager.createQuery(jpql, Course.class)
                    .setParameter("code", code)
                    .getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<Course> gePrivatetCourses() {
        String jpql = "SELECT c FROM Course c WHERE c.visibility = :publicVisibility";
        return this.entityManager.createQuery(jpql, Course.class)
                .setParameter("publicVisibility", CourseVisibility.PRIVADA)
                .getResultList();
    }

    public void updateCoursesPrivateToPublic() {
        String jpql = "UPDATE Course c SET c.visibility = :newVisibility WHERE c.visibility = :oldVisibility";
        int updatedCourses = this.entityManager.createQuery(jpql)
                .setParameter("newVisibility", CourseVisibility.PUBLICA)
                .setParameter("oldVisibility", CourseVisibility.PRIVADA)
                .executeUpdate();
        System.out.println("Updated courses:  " + updatedCourses);

    }

    public List<Course> getPublicCourses() {
        String jpql = "SELECT c From Course c WHERE c.visibility = :visibility";
        return this.entityManager.createQuery(jpql, Course.class)
                .setParameter("visibility", CourseVisibility.PUBLICA)
                .getResultList();
    }
}
