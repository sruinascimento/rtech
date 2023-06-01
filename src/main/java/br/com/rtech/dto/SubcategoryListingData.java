package br.com.rtech.dto;

import br.com.rtech.dto.CourseListingData;

import java.util.List;

public record SubcategoryListingData(String name, String code, String studyGuide, List<CourseListingData> courses) {
}
