public class SubCategory extends CategoryInformation {

    private Category category;

    public SubCategory(String name, String code, Category category) {
        super(name, code);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
