package br.com.rsoft.rtech.model;

import java.util.List;

public record SubcategoryListingData(String name, String code, String studyGuide, List<CourseListingData> courses) {
}
