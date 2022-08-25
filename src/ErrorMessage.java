public enum ErrorMessage {
    ERROR_MESSAGE_NAME("Invalid course name"),
    ERROR_MESSAGE_CODE("Invalid course code"),
    ERROR_MESSAGE_ESTIMATED_TIME_COURSE_COMPLETION("Invalid time for course conclusion"),
    ERROR_MESSAGE_INSTRUCTORS_NAME("Invalid instructor's name"),
    ERROR_MESSAGE_QUESTION_TYPE("Invalid question type");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}
