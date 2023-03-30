package br.com.rtech.model;

import br.com.rtech.validation.Validate;

import javax.persistence.*;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "code_activity")
    private String code;
    @Column(name = "is_inactive", columnDefinition = "TINYINT")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "id_activity_type")
    private ActivityType type;
    @ManyToOne
    @JoinColumn(name = "id_section")
    private Section section;

    public Activity(String title, String code, Section section) {
        Validate.validateText(title, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.ACTIVITY_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.ACTIVITY_CODE.getMessage());

        this.title = title;
        this.code = code;
        this.section = section;
    }

    public Activity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", active=" + active +
                ", type='" + type + '\'' +
                ", section=" + section +
                '}';
    }
}
