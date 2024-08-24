package com.emazon.categoria.infrastructure.controller;

import com.emazon.categoria.infrastructure.dto.CategoryDTO;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/emazon")
@Tag(name = "Controlador de categoria", description = "Este controlador maneja todas las operaciones relacionadas con las categorías como la creación")
public class CategoryController {

    public CategoryController(ICreateCategoryUseCase iCreateCategoryUseCase) {
        this.iCreateCategoryUseCase = iCreateCategoryUseCase;
    }

    private final ICreateCategoryUseCase iCreateCategoryUseCase;

    @Operation(
            summary = "Crear una nueva categoría",
            description = "Este endpoint permite la creación de una nueva categoría. El cliente debe proporcionar los detalles de la categoría en el cuerpo de la solicitud. Si la operación es exitosa, se devuelve la categoría creada junto con un código de estado 201."
    )
    @PostMapping("save-category")
    public ResponseEntity<CategoryDTO> saveCategory(@Valid @RequestBody CategoryDTO category){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCreateCategoryUseCase.createCategory(category));
    }
}
