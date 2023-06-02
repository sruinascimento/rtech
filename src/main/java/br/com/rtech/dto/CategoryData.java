package br.com.rtech.dto;

import br.com.rtech.model.Category;
import br.com.rtech.model.StateActivation;
import jakarta.validation.constraints.NotBlank;

public record CategoryData(
        @NotBlank
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String code,
        @NotBlank
        StateActivation active) {
    public CategoryData(Category category) {
        this(category.getId(), category.getName(), category.getCode(), category.getActive());
    }
}
