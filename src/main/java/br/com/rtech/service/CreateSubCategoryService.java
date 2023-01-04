package main.java.br.com.rtech.service;

import main.java.br.com.rtech.model.Category;
import main.java.br.com.rtech.model.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateSubCategoryService {
    //, List<Category> categories param
    public static List<SubCategory> generateObjecSubCategory(String path, Map<String, Category> categories) {
        List<SubCategory> subCategories = new ArrayList<>();
        List<String[]> atributesSubCategory = ExtractorAtributesService.getAtributes(path);

        for (String[] atributes : atributesSubCategory) {
            String name = atributes[0];
            String code = atributes[1];
            String order = atributes[2];
            String description = atributes[3];
            String status = atributes[4];
            String categoryCode = atributes[5];

            Category category = categories.get(categoryCode);
            if (category == null) throw new RuntimeException("Invalid category: " + categoryCode);
            SubCategory subCategory = new SubCategory(name, code);
            subCategory.setOrder(order);
            subCategory.setDescription(description);
            if (status.equals("ATIVA")) subCategory.setActive(true);
            if (status.equals("INATIVA")) subCategory.setActive(false);
            subCategory.setCategory(category);
            subCategories.add(subCategory);
        }

        return subCategories;
    }

}
