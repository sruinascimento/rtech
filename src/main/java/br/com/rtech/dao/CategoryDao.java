package br.com.rtech.dao;

import br.com.rtech.model.Category;
import br.com.rtech.model.StateActivation;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {
    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Category> getActiveCategories() {
        String jpql = "SELECT c FROM Category c WHERE c.active = :active ORDER BY c.order";
        return this.entityManager.createQuery(jpql, Category.class)
                .setParameter("active", StateActivation.ATIVA)
                .getResultList();
    }

    public List<Category> getCategories() {
        String jpql = "SELECT c FROM Category c ORDER BY c.order";
        return this.entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public void insert(Category category) {
        this.entityManager.persist(category);
    }

    public Category getCategoryById(Long id) {
        return this.entityManager.find(Category.class, id);
    }
}
