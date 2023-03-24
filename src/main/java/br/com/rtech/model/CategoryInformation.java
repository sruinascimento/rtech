//package br.com.rtech.model;
//
//import br.com.rtech.validation.Validate;
//
//import javax.persistence.*;
//
//public abstract class CategoryInformation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name_category")
//    private String name;
//    @Column(name = "code_category")
//    private  String code;
//    @Column(name = "description_category")
//    private String description;
//    @Column(name = "study_guide")
//    private String studyGuide;
//    @Column(name = "is_active")
//    @Enumerated(EnumType.STRING)
//    private StateActivation active;
//    @Column(name = "order_category")
//    private int order;
//
//
//    public CategoryInformation(String name, String code) {
//        Validate.validateText(name, "[a-zA-Zç\\sáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", ErrorMessage.CATEGORY_NAME.getMessage());
//        Validate.validateText(code, "[a-z0-9]+[a-z-0-9]*[a-z0-9]",ErrorMessage.CATEGORY_CODE.getMessage());
//        this.name = name;
//        this.code = code;
//        this.active = StateActivation.INATIVA;
//    }
//
//    public CategoryInformation() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getStudyGuide() {
//        return studyGuide;
//    }
//
//    public void setStudyGuide(String studyGuide) {
//        this.studyGuide = studyGuide;
//    }
//
//    public StateActivation isActive() {
//        return active;
//    }
//
//    public void setActive(String stateActive) {
//        if (stateActive.equals("ATIVA")) this.active = StateActivation.ATIVA;
//        if (stateActive.equals("INATIVA")) this.active = StateActivation.INATIVA;
//    }
//
//    public int getOrder() {
//        return order;
//    }
//
//    public void setOrder(int order) {
//        this.order = order;
//    }
//
//    public void setOrder(String order) {
//        if (order != null && !order.trim().equals("")) {
//            this.setOrder(Integer.parseInt(order));
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "br.com.rtech.model.CategoryInformation{" +
//                "name='" + name + '\'' +
//                ", code='" + code + '\'' +
//                ", description='" + description + '\'' +
//                ", studyGuide='" + studyGuide + '\'' +
//                ", active=" + active +
//                ", order=" + order +
//                '}';
//    }
//}
