package br.com.rsoft.rtech.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT c FROM Category c WHERE c.active = ?1")
    public List<Category> findCategoriesByActive(StateActivation statusCategory);

    @Query(value = "SELECT c from Category c  WHERE c.code = ?1")
    public Category findCategoriesByCode(String code);


}
