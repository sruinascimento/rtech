package br.com.rsoft.rtech.model;

public record CategoryUpdateData(
        Long id,
        String name,
        String code,
        String description,
        String studyGuide,
        StateActivation active,
        Integer order,
        String iconPath,

        String htmlColorCode) {


    public static CategoryUpdateData createWithCategoryClass(Category category) {
        return new CategoryUpdateData(
                category.getId(), category.getName(), category.getCode(), category.getDescription(), category.getStudyGuide(),
                category.getActive(), category.getOrder(), category.getIconPath(), category.getHtmlColorCode()
        );
    }

}
