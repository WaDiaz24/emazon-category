package com.emazon.categoria.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

public record CategoryDTO(
        Long id,
        @NotBlank(message = "El nombre no debe estar vacio")
        @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
        String name,
        @NotBlank(message = "La descripción no debe estar vacia")
        @Size(max = 90, message = "La descripción no puede tener más de 90 caracteres")
        String description
) {
}
