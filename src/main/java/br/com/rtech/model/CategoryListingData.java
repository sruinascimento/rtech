package br.com.rsoft.rtech.model;


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
}
