package br.com.rtech.model;

import br.com.rtech.validation.Validate;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_category")
    private String name;
    @Column(name = "code_category")
    private  String code;
    @Column(name = "description_category")
    private String description;
    @Column(name = "study_guide")
    private String studyGuide;
    @Column(name = "is_active")
    @Enumerated(EnumType.STRING)
    private StateActivation active;
    @NotNull
    @Column(name = "order_category")
    private Integer order;
    @Column(name = "icon_path")
    private String iconPath;
    @Column(name = "html_color_code")
    private String htmlColorCode;

    public Category(String name, String code) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.CATEGORY_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.CATEGORY_CODE.getMessage());
        this.name = name;
        this.code = code;
    }

    public Category() {
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getHtmlColorCode() {
        return htmlColorCode;
    }

    public void setHtmlColorCode(String htmlColorCode) {
        Validate.validateText(htmlColorCode, "#[A-Fa-f0-9]{6}", ErrorMessage.HTML_COLOR_CODE.getMessage());
        this.htmlColorCode = htmlColorCode;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public StateActivation getActive() {
        return active;
    }

    public boolean isActive() {
        return this.active.equals(StateActivation.ATIVA);
    }


    public void setActive(String stateActive) {
        if (stateActive.equals("ATIVA")) this.active = StateActivation.ATIVA;
        if (stateActive.equals("INATIVA")) this.active = StateActivation.INATIVA;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (order != null && !order.trim().equals("")) {
            this.order = (Integer.parseInt(order));
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", iconPath='" + iconPath + '\'' +
                ", htmlColorCode='" + htmlColorCode + '\'' +
                '}';
    }
}
