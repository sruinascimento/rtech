package br.com.rtech.service;

import br.com.rtech.model.Category;
import java.util.ArrayList;
import java.util.List;

public class CreateCategoryService {

    public static List<Category> generateObjectCategory(String path) {
        List<Category> categories = new ArrayList<>();
        List<String[]> categoryAtributes = ExtractorAtributesService.getAtributes(path);

        for (String[] atributes : categoryAtributes) {
                String name = atributes[0];
                String code = atributes[1];
                String order = atributes[2];
                String description = atributes[3];
                String status = atributes[4];
                String icon = atributes[5];
                String color = atributes[6];
                try {
                    Category category = new Category(name, code);
                    category.setOrder(order);
                    category.setDescription(description);
                    category.setActive(status);
                    category.setActive(status);
                    category.setIconPath(icon);
                    category.setHtmlColorCode(color);
                    categories.add(category);
                } catch (IllegalArgumentException e) {
                  throw new RuntimeException(e);
                }
        }
        return categories;
    }

}
