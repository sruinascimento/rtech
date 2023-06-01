package br.com.rsoft.rtech.model;

import br.com.rsoft.rtech.validation.Validate;
import jakarta.persistence.*;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_section")
    private String name;
    @Column(name = "code_section")
    private String code;
    @Column(name = "order_section")
    private int order;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "is_test")
    private boolean test;
    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    public Section(String name, String code, Course course) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.SECTION_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.SECTION_CODE.getMessage());
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public Section() {
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
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", active=" + active +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
