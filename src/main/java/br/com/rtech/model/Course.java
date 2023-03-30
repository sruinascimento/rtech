package br.com.rtech.model;

import br.com.rtech.validation.Validate;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_course")
    private String name;
    @Column(name = "code_course")
    private String code;
    @Column(name = "estimated_time_course_completion", columnDefinition = "TINYINT")
    private int estimatedTimeCourseCompletion;
    @Column(name = "public_visibility")
    @Enumerated(EnumType.STRING)
    private CourseVisibility visibility;
    @Column(name = "target_public", columnDefinition = "TEXT")
    private String targetPublic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instructor")
    private Instructor instructor;
    @Column(name = "syllabus", columnDefinition = "TEXT")
    private String syllabus;

    @Column(name = "developed_skills", columnDefinition = "TEXT")
    private String developedSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subcategory")
    private SubCategory subCategory;


    public Course(String name, String code, int estimatedTimeCourseCompletion, Instructor instructor) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.COURSE_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.COURSE_CODE.getMessage());
        Validate.validateNumberRange(estimatedTimeCourseCompletion, 1, 20, ErrorMessage.ESTIMATED_TIME_COURSE_COMPLETION.getMessage());
        this.name = name;
        this.code = code;
        this.estimatedTimeCourseCompletion = estimatedTimeCourseCompletion;
        this.instructor = instructor;
        this.visibility = CourseVisibility.PRIVADA;
    }

    public Course() {

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

    public CourseVisibility getVisibility() {
        return this.visibility;
    }



    public boolean isPublicVisibility() {
        return this.visibility.equals(CourseVisibility.PUBLICA);
    }

    public void setVisibility(String publicVisibility) {
        if (CourseVisibility.PRIVADA.toString().equalsIgnoreCase(publicVisibility)) {
            this.visibility = CourseVisibility.PUBLICA;
        }
    }

    public String getTargetPublic() {
        return this.targetPublic;
    }

    public void setTargetPublic(String targetPublic) {
        this.targetPublic = targetPublic;
    }

    public String getInstructor() {
        return this.instructor.getName();
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + this.name + '\'' +
                ", code='" + this.code + '\'' +
                ", estimatedTimeCourseCompletion=" + this.estimatedTimeCourseCompletion +
                ", publicVisibility=" + this.visibility +
                ", targetPublic='" + this.targetPublic + '\'' +
                ", instructor=" + this.instructor.getName() +
                ", courseSyllabus='" + this.syllabus + '\'' +
                ", developedSkills='" + this.developedSkills + '\'' + '}';
    }

}
