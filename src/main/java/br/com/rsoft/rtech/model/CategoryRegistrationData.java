package br.com.rsoft.rtech.model;

import jakarta.validation.constraints.*;

public record CategoryRegistrationData(
        @NotBlank @Pattern(regexp = "[a-zA-Zç\\sáàâãéèêíïóôõöúñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ:]{3,}")
        String name,
        @NotBlank @Pattern(regexp = "[a-z0-9]+[a-z-0-9]*[a-z0-9]")
        String code,
        @NotBlank
        String description,
        @NotBlank
        String studyGuide,
        @NotNull
        StateActivation active,
        @Min(1) @Max(20)
        Integer order,
        @NotBlank
        String iconPath,

        @NotBlank @Pattern(regexp = "#[0-9a-fA-F]{6}")
        String htmlColorCode
) {
}
