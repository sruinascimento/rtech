package br.com.rtech.dto;


import br.com.rtech.model.Category;

import java.util.List;

public record CategoryListingData(
        String name,
        String code,
        Integer order,
        String htmlColorCode,
        String studyGuide,
        Long amountCourses,
        List<SubcategoryListingData> subcategories
) {

    public CategoryListingData(Category category, Long amountCourses, List<SubcategoryListingData> subcategories) {
        this(category.getName(),
                category.getCode(),
                category.getOrder(),
                category.getHtmlColorCode(),
                category.getStudyGuide(),
                amountCourses,
                subcategories);
    }
}
