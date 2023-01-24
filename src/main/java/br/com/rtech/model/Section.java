package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public class Section {

    private String name;
    private String code;
    private int order;
    private boolean active;
    private boolean test;
    private Course course;

    public Section(String name, String code, Course course) {
        Validate.validateText(name, "[a-zA-Zç\\s^~´]{3,}", ErrorMessage.SECTION_NAME.getMessage());
//        Validate.validateWord(name, ErrorMessage.SECTION_NAME);
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.SECTION_CODE.getMessage());
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTest() {
        return this.test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public Course getCourse() {
        return this.course;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", active=" + active +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
