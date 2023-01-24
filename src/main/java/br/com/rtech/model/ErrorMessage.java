package br.com.rtech.model;

public enum ErrorMessage {
    COURSE_NAME("Invalid course name"),
    COURSE_CODE("Invalid course code"),
    ESTIMATED_TIME_COURSE_COMPLETION("Invalid time for course conclusion"),
    SECTION_NAME("Invalid section name"),
    SECTION_CODE("Invalid section code"),
    ACTIVITY_NAME("Invalid activity name"),
    ACTIVITY_CODE("Invalid activity code"),
    ACTIVITY_TYPE_TEXT("Invalid text about activity type"),
    CATEGORY_NAME("Invalid category name"),
    CATEGORY_CODE("Invalid category code"),
    INSTRUCTORS_NAME("Invalid instructor's name"),
    QUESTION_TYPE("Invalid question type"),
    ALTERNATIVE_TEXT("Invalid text alternative"),
    HTML_COLOR_CODE("Invalid html color code");

    private String message;

    ErrorMessage(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }


}
