package br.com.rtech.controller;

import br.com.rtech.dto.CategoryData;
import br.com.rtech.dto.CategoryUpdateData;
import br.com.rtech.model.Category;
import br.com.rtech.dto.CategoryRegistrationData;
import br.com.rtech.model.CategoryRepository;
import br.com.rtech.dto.FormCategoryData;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryAdminController {
    private CategoryRepository categoryRepository;

    public CategoryAdminController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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
        Category category = data.toCategory();
        categoryRepository.save(category);
        return "redirect:/admin/categories";

    }

    @GetMapping("admin/categories/{code}")
    public ModelAndView getCategoryByCode(@PathVariable String code) {
        ModelAndView modelAndView = new ModelAndView("altera-categoria");
        Category category = categoryRepository.findCategoriesByCode(code);
        modelAndView.addObject("category", new FormCategoryData(category));
        return modelAndView;
    }

    @PostMapping(value = "admin/categories/{code}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @Transactional
    public String updateCategoryByCode(@PathVariable String code, @ModelAttribute("data") CategoryUpdateData data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "altera-categoria";
        }
        try{
            Category category = categoryRepository.getReferenceById(data.id());

            category.setName(data.name());
            category.setDescription(data.description());
            category.setActive(data.active());
            category.setOrder(data.order());
            category.setIconPath(data.iconPath());
            category.setIconPath(data.iconPath());
            categoryRepository.save(category);

            return "redirect:/admin/categories";
        } catch (EntityNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
}
