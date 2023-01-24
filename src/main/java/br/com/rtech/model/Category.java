package br.com.rtech.model;

import br.com.rtech.validation.Validate;

public class Category extends  CategoryInformation {

    private String iconPath;
    private String htmlColorCode;

    public Category(String name, String code) {
        super(name, code);
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

    @Override
    public String toString() {
        return "br.com.rtech.model.Category{" +
                "iconPath='" + iconPath + '\'' +
                ", htmlColorCode='" + htmlColorCode + '\'' +
                '}' + super.toString();
    }
}
