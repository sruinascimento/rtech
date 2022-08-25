public class Course {

    private String name;
    private String code;
    private int estimatedTimeCourseCompletion;
    private boolean privateVisibility;
    private String targetPublic;
    private Instructor instructor;
    private String courseSyllabus;
    private String developedSkills;


    public Course(String name, String code, int estimatedTimeCourseCompletion, String instructorsName) {
        this.toValidateArgumentsInput(name, code, estimatedTimeCourseCompletion, instructorsName);
        this.name = name;
        this.code = code;
        this.estimatedTimeCourseCompletion = estimatedTimeCourseCompletion;
        this.instructor = new Instructor(instructorsName);
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getEstimatedTimeCourseCompletion () {
        return this.estimatedTimeCourseCompletion;
    }

    public boolean isPrivateVisibility() {
        return this.privateVisibility;
    }

    public void setPrivateVisibility (boolean privateVisibility) {
        this.privateVisibility = privateVisibility;
    }

    public String getTargetPublic() {
        return this.targetPublic;
    }

    public void setTargetPublic(String targetPublic) {
        this.targetPublic = targetPublic;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public String getCourseSyllabus() {
        return this.courseSyllabus;
    }

    public void setCourseSyllabus(String courseSyllabus) {
        this.courseSyllabus = courseSyllabus;
    }

    public String getDevelopedSkills() {
        return this.developedSkills;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + this.name + '\'' +
                ", code='" + this.code + '\'' +
                ", estimatedTimeCourseCompletion=" + this.estimatedTimeCourseCompletion +
                ", privateVisibility=" + this.privateVisibility +
                ", targetPublic='" + this.targetPublic + '\'' +
                ", instructor=" + this.instructor.getName() +
                ", courseSyllabus='" + this.courseSyllabus + '\'' +
                ", developedSkills='" + this.developedSkills + '\'' +
                '}';
    }

    private void toValidateArgumentsInput(String name, String code, int estimatedTimeCourseCompletion, String instructorsName) {
        Validate.validateName(name, ErrorMessage.ERROR_MESSAGE_NAME.getErrorMessage());
        Validate.validateCode(code, ErrorMessage.ERROR_MESSAGE_CODE.getErrorMessage());
        Validate.validateNumberRange(estimatedTimeCourseCompletion, ErrorMessage.ERROR_MESSAGE_ESTIMATED_TIME_COURSE_COMPLETION.getErrorMessage());
        Validate.validateNameInstructor(instructorsName, ErrorMessage.ERROR_MESSAGE_INSTRUCTORS_NAME.getErrorMessage());

    }
}
