package br.com.rsoft.rtech.model;

import br.com.rsoft.rtech.validation.Validate;
import jakarta.persistence.*;


@Entity
@Table(name = "subcategory")
public class SubCategory  implements Comparable<SubCategory> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_subcategory")
    private String name;
    @Column(name = "code_subcategory")
    private  String code;
    @Column(name = "description_subcategory")
    private String description;
    @Column(name = "study_guide")
    private String studyGuide;
    @Column(name = "is_active")
    @Enumerated(EnumType.STRING)
    private StateActivation active;
    @Column(name = "order_subcategory")
    private Integer order;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public SubCategory(String name, String code) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.CATEGORY_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.CATEGORY_CODE.getMessage());
        this.name = name;
        this.code = code;
    }

    public SubCategory() {
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
        if (description == null || description.equals("")) {
            return "Sem descrição";
        }
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (order != null && !order.trim().equals("")) {
            this.order = (Integer.parseInt(order));
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", category=" + category +
                '}';
    }

    @Override
    public int compareTo(SubCategory subCategory) {
        return this.getOrder() - subCategory.getOrder();
    }
}
