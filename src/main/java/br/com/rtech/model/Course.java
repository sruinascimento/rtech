package br.com.rtech.model;

public class Course {

    private String name;
    private String code;
    private int estimatedTimeCourseCompletion;
    private boolean publicVisibility;
    private String targetPublic;
    private Instructor instructor;
    private String syllabus;
    private String developedSkills;
    private SubCategory subCategory;


    public Course(String name, String code, int estimatedTimeCourseCompletion, String instructorsName) {
        Validate.validateWord(name, ErrorMessage.COURSE_NAME);
        Validate.validateCode(code, ErrorMessage.COURSE_CODE);
        Validate.validateNumberRange(estimatedTimeCourseCompletion, ErrorMessage.ESTIMATED_TIME_COURSE_COMPLETION);
        Validate.validateNameInstructor(instructorsName, ErrorMessage.INSTRUCTORS_NAME);
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

    public boolean isPublicVisibility() {
        return this.publicVisibility;
    }

    public void setPublicVisibility(boolean publicVisibility) {
        this.publicVisibility = publicVisibility;
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

    public String getSyllabus() {
        return this.syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getDevelopedSkills() {
        return this.developedSkills;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Course{" +
                "name='" + this.name + '\'' +
                ", code='" + this.code + '\'' +
                ", estimatedTimeCourseCompletion=" + this.estimatedTimeCourseCompletion +
                ", publicVisibility=" + this.publicVisibility +
                ", targetPublic='" + this.targetPublic + '\'' +
                ", instructor=" + this.instructor.getName() +
                ", courseSyllabus='" + this.syllabus + '\'' +
                ", developedSkills='" + this.developedSkills + '\'' +
                this.subCategory.toString() +  '}';
    }

}
