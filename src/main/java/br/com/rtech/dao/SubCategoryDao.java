package br.com.rtech.dao;

import br.com.rtech.model.StateActivation;
import br.com.rtech.model.SubCategory;

import javax.persistence.EntityManager;
import java.util.List;

public class SubCategoryDao {
    private EntityManager entityManager;

    public SubCategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<SubCategory> geActivetSubcategories() {
        String jpql = "SELECT s FROM SubCategory s WHERE s.active = :active ORDER BY s.order";
        return this.entityManager.createQuery(jpql, SubCategory.class)
                .setParameter("active", StateActivation.ATIVA)
                .getResultList();
    }

    public List<String> getNameOfSubcategoriesHasntDescription() {
        String jpql = "SELECT s.name FROM SubCategory s WHERE s.description IS NULL";
        return this.entityManager.createQuery(jpql, String.class)
                .getResultList();
    }

}
