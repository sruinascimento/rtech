package br.com.rtech.dto;

import br.com.rtech.model.SubCategory;

import java.util.List;

public record SubcategoryListingData(String name, String code, String studyGuide, List<CourseListingData> courses) {

    public SubcategoryListingData(SubCategory subCategory, List<CourseListingData> courses) {
        this(subCategory.getName(), subCategory.getCode(), subCategory.getStudyGuide(), courses);
    }
}
