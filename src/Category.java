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
        this.htmlColorCode = htmlColorCode;
    }
}
