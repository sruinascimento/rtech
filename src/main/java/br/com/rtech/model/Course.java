package br.com.rtech.model;

import br.com.rtech.validation.Validate;

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
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.COURSE_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.COURSE_CODE.getMessage());
        Validate.validateNumberRange(estimatedTimeCourseCompletion, 1, 20, ErrorMessage.ESTIMATED_TIME_COURSE_COMPLETION.getMessage());
        Validate.validateText(instructorsName, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.INSTRUCTORS_NAME.getMessage());
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
