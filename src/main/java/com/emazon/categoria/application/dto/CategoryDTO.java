package com.emazon.categoria.application.dto;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record CategoryDTO(
        Long id,
        @NotBlank(message = "Validando desde el dto")
        String name,
        String description
) {
}
