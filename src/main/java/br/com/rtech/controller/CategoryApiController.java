package br.com.rtech.controller;

import br.com.rtech.dto.CategoryListingData;
import br.com.rtech.dto.CourseListingData;
import br.com.rtech.dto.SubcategoryListingData;
import br.com.rtech.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryApiController {
    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final CourseRepository courseRepository;

    public CategoryApiController(CategoryRepository categoryRepository, SubcategoryRepository subcategoryRepository, CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.subcategoryRepository = subcategoryRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping(value = "api/categories", produces = {"application/json", "application/xml"})
    public List<CategoryListingData> response() {
        return getActiveCategories();

    }

    private List<CategoryListingData> getActiveCategories() {
        Map<String, Long> coursesByCategory = getCourseCountByCategory();
        return categoryRepository.findCategoriesByActive(StateActivation.ATIVA)
                .stream()
                .map(category -> {
                            return new CategoryListingData(
                                    category, coursesByCategory.get(category.getName()), getActiveSubcategoriesByCategory(category.getName()));
                        }
                )
                .toList();

    }

    private List<SubcategoryListingData> getActiveSubcategoriesByCategory(String categoryName) {
        return subcategoryRepository.findSubcategoriesByActive(StateActivation.ATIVA, categoryName).stream()
                .map(subCategory -> new SubcategoryListingData(subCategory, getPublicCoursesBySubcategory(subCategory.getName())))
                .toList();
    }

    private List<CourseListingData> getPublicCoursesBySubcategory(String subcategoryName) {
        return courseRepository.findCourseByActive(CourseVisibility.PUBLICA, subcategoryName)
                .stream()
                .map(CourseListingData::new)
                .toList();
    }

    private Map<String, Long> getCourseCountByCategory() {
        List<Object[]> amountCoursesByCategory = courseRepository.getCourseCountByCategory();
        Map<String, Long> amountCoursesByCategoryMapConverted = new HashMap<>();
        for (var course : amountCoursesByCategory) {
            String categoryName = (String) course[0];
            Long amount = (Long) course[1];
            amountCoursesByCategoryMapConverted.put(categoryName, amount);
        }
        return amountCoursesByCategoryMapConverted;
    }

}
