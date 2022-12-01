package br.com.rtech.service;

import br.com.rtech.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class CreateSubCategoryService {
    //, List<Category> categories param
    public static List<SubCategory> generateObjecSubCategory(String path) {
        List<SubCategory> subCategories = new ArrayList<>();
        List<String[]> atributesSubCategory = ExtractorAtributesService.getAtributes(path);

        for (String[] atributes : atributesSubCategory) {
            String name = atributes[0];
            String code = atributes[1];
            String order = atributes[2];
            String description = atributes[3];
            String status = atributes[4];
            String categoryCode = atributes[5];

            try {
                SubCategory subCategory = new SubCategory(name, code);
                subCategory.setOrder(Integer.parseInt(order));
                subCategory.setDescription(description);
                if (status.equals("ATIVA")) subCategory.setActive(true);
                if (status.equals("INATIVA")) subCategory.setActive(false);
                subCategory.setCategory(categoryCode);
                subCategories.add(subCategory);
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
            }
        }

        return subCategories;
    }

}
