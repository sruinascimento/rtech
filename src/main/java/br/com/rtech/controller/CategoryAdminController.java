package br.com.rsoft.rtech.controller;

import br.com.rsoft.rtech.dto.CategoryData;
import br.com.rsoft.rtech.model.Category;
import br.com.rsoft.rtech.dto.CategoryRegistrationData;
import br.com.rsoft.rtech.model.CategoryRepository;
import br.com.rsoft.rtech.model.CategoryUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryAdminController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("admin/categories")
    public ModelAndView getAdminCategories() {
        ModelAndView modelAndView = new ModelAndView("admin-categories");

        List<CategoryData> categories = categoryRepository.findAll()
                .stream()
                .map(CategoryData::new)
                .toList();


        modelAndView.addObject("categories", categories);

        return modelAndView;

    }

    @GetMapping("admin/categories/new")
    public String getNewCategoryPage() {
        return "cadastro-categoria";
    }


    @PostMapping(value = "admin/categories", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @Transactional
    public String saveCategory(@Valid @ModelAttribute("data") CategoryRegistrationData data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadastro-categoria";
        }
        Category category = new Category();
        category.setDataCategory(data);
        categoryRepository.save(category);

        return "redirect:/admin/categories";

    }

    @GetMapping("admin/categories/{code}")
    public ModelAndView getCategoryByCode(@PathVariable String code) {
        ModelAndView modelAndView = new ModelAndView("altera-categoria");
        Category category = categoryRepository.findCategoriesByCode(code);
        modelAndView.addObject("category", CategoryUpdateData.createWithCategoryClass(category));
        return modelAndView;
    }

    @PostMapping(value = "admin/categories/{code}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @Transactional
    public String updateCategoryByCode(@PathVariable String code, @ModelAttribute("data") @Valid CategoryRegistrationData data, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "altera-categoria";
        }

        System.out.println("POST" + data);
        Category category = categoryRepository.findCategoriesByCode(code);
        category.setDataCategory(data);
        categoryRepository.save(category);
        return "redirect:/admin/categories";

    }
}
