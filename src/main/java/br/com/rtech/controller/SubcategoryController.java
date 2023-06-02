package br.com.rtech.controller;

import br.com.rtech.model.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubcategoryController {
    @Autowired
    private SubcategoryRepository subcategoryRepository;


    @GetMapping("admin/subcategories/{id}")
    public String getSubcategories(@PathVariable("id") Long id) {
        subcategoryRepository.findSubCategoriesByCategory_Id(id);
        return null;
    }
}
