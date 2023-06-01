package br.com.rtech.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<SubCategory, Long> {
    @Query(value = "SELECT s FROM SubCategory s WHERE s.active = ?1 AND s.category.name = ?2")
    List<SubCategory> findSubcategoriesByActive(StateActivation statusCategory, String categoryName);

    List<SubCategory> findSubCategoriesByCategory_Id(Long id);


}
