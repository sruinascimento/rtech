package br.com.rtech.dto;

import br.com.rtech.model.Category;
import jakarta.validation.constraints.*;

public record CategoryRegistrationData(
        @NotBlank @Pattern(regexp = "[a-zA-Zç\\sáàâãéèêíïóôõöúñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}", message = "O nome só pode conter letras e acentos")
        String name,
        @NotBlank @Pattern(regexp = "[a-z0-9]+[a-z-0-9]*[a-z0-9]", message = "O código só pode conter letras minúsculas números e hífen")
        String code,
        String description,
        String studyGuide,
        String active,
        @Min(1) @Max(20)
        Integer order,
        String iconPath,
        @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "código deve ser em hexadecimal")
        String htmlColorCode
) {

        public Category toCategory() {
                return new Category(name(),
                        code(),
                        description(),
                        studyGuide(),
                        active(),
                        order(),
                        iconPath(),
                        htmlColorCode());
        }

}
