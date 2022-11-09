package br.com.rtech.service;

import br.com.rtech.model.Category;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCategoryService {

    public static List<Category> generateObjectCategory(String pathFile) {
        List<Category> categories = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathFile))){
            //skip the labels
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] atributes = scanner.nextLine().split(",");
                String name = atributes[0];
                String code = atributes[1];
                String order = atributes[2];
                String description = atributes[3];
                String status = atributes[4];
                String icon = atributes[5];
                String color = atributes[6];
                try {
                    Category category = new Category(name, code);
                    category.setOrder(Integer.parseInt(order));
                    category.setDescription(description);
                    if (status.equals("ATIVA")) category.setActive(true);
                    if (status.equals("INATIVA")) category.setActive(false);
                    category.setIconPath(icon);
                    category.setHtmlColorCode(color);
                    categories.add(category);
                } catch (Exception ignored) {
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

}
