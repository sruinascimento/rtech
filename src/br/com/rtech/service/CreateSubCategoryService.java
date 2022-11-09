package br.com.rtech.service;

import br.com.rtech.model.SubCategory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateSubCategoryService {
    //, List<Category> categories param
    public static List<SubCategory> generateObjecSubCategory(String pathFile) {
        List<SubCategory> subCategories = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathFile))){
            //read the labels
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] atributes = scanner.nextLine().split(",");
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
                    } catch (IllegalArgumentException ignored) {
                    }
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return subCategories;

    }

}
