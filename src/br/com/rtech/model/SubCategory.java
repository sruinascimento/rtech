package br.com.rtech.model;

public class SubCategory extends CategoryInformation implements Comparable<SubCategory> {

    private String category;

    public SubCategory(String name, String code) {
        super(name, code);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                ", category='" + category + '\'' +
                "}\n " +
                super.toString();
    }

    @Override
    public int compareTo(SubCategory subCategory) {
        return this.getOrder() - subCategory.getOrder();
    }
}
