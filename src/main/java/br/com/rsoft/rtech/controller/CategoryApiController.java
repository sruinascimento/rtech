package br.com.rsoft.rtech.controller;

import br.com.rsoft.rtech.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CategoryApiController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Autowired
    CourseRepository courseRepository;

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
                                    category.getName(), category.getCode(), category.getOrder(), category.getHtmlColorCode(),
                                    category.getStudyGuide(), coursesByCategory.get(category.getName()), getActiveSubcategoriesByCategory(category.getName()));
                        }
                )
                .collect(Collectors.toList());

    }

    private List<SubcategoryListingData> getActiveSubcategoriesByCategory(String categoryName) {
        return subcategoryRepository.findSubcategoriesByActive(StateActivation.ATIVA, categoryName).stream()
                .map(subCategory -> new SubcategoryListingData(subCategory.getName(), subCategory.getCode(), subCategory.getStudyGuide(), getPublicCoursesBySubcategory(subCategory.getName())))
                .collect(Collectors.toList());
    }

    private List<CourseListingData> getPublicCoursesBySubcategory(String subcategoryName) {
        return courseRepository.findCourseByActive(CourseVisibility.PUBLICA, subcategoryName)
                .stream()
                .map(course -> new CourseListingData(course.getName(), course.getCode(), course.getEstimatedTimeCourseCompletion(), course.getDevelopedSkills()))
                .collect(Collectors.toList());
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
