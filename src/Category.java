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
        Validate.validateHtmlColorHexadecimal(htmlColorCode, ErrorMessage.HTML_COLOR_CODE.getErrorMessage());
        this.htmlColorCode = htmlColorCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "iconPath='" + iconPath + '\'' +
                ", htmlColorCode='" + htmlColorCode + '\'' +
                '}' + super.toString();
    }
}
