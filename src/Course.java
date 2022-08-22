public class Course {

    private String name;
    private String code;
    private double estimatedTimeCourseCompletion;
    private boolean visibility;
    private String targetPublic;
    private String instructorsName;


    public Course(String name, String code, int estimatedTimeCourseCompletion) {
        this.toValidateArgumentsInput(name, code, estimatedTimeCourseCompletion);
        this.name = name;
        this.code = code;
        this.estimatedTimeCourseCompletion = estimatedTimeCourseCompletion;

    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "ok";
    }

    private void toValidateArgumentsInput(String name, String code, int estimatedTimeCourseCompletion) {
        //Refatorar para ENUMS
        final String ERROR_MESSAGE_NAME = "Invalid name.";
        final String ERROR_MESSAGE_CODE = "Invalid code";
        final String ERROR_MESSAGE_ESTIMATED_TIME_COURSE_COMPLETION = "Invalid time for course conclusion";
        Validate.validateName(name, ERROR_MESSAGE_NAME);
        Validate.validateCode(code, ERROR_MESSAGE_CODE);
        Validate.validateNumberRange(estimatedTimeCourseCompletion, ERROR_MESSAGE_ESTIMATED_TIME_COURSE_COMPLETION);

    }
}
