package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public abstract class CategoryInformation {
    private String name;
    private  String code;
    private String description;
    private String studyGuide;
    private boolean active;
    private int order;


    public CategoryInformation(String name, String code) {
        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.CATEGORY_NAME.getMessage());
        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.CATEGORY_CODE.getMessage());
        this.name = name;
        this.code = code;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setOrder(String order) {
        if (order != null && !order.trim().equals("")) {
            this.setOrder(Integer.parseInt(order));
        }
    }

    @Override
    public String toString() {
        return "br.com.rtech.model.CategoryInformation{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                '}';
    }
}
