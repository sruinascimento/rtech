package br.com.rtech.dto;

import br.com.rtech.model.Course;

public record CourseListingData(String nome, String code, Integer estimatedTimeCourseCompletion, String developedSkills) {
    public CourseListingData(Course course) {
        this(course.getName(), course.getCode(), course.getEstimatedTimeCourseCompletion(), course.getDevelopedSkills());
    }
}
