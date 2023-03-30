package br.com.rtech.dao;

import br.com.rtech.model.Instructor;

import javax.persistence.EntityManager;

public class InstructorDao {

    private EntityManager entityManager;

    public InstructorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Instructor instructor) {
        this.entityManager.persist(instructor);
    }
}
