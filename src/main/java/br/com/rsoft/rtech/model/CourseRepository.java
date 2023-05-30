package br.com.rsoft.rtech.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT c FROM Course c WHERE c.visibility = ?1 AND c.subCategory.name = ?2")
    public List<Course> findCourseByActive(CourseVisibility courseVisibility, String subcategoryName);

    @Query("SELECT c.subCategory.category.name, COUNT(c.name)  FROM Course c GROUP BY c.subCategory.category.name")

    List<Object[]> getCourseCountByCategory();
}
