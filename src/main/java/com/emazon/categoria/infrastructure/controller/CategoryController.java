package com.emazon.categoria.infrastructure.controller;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emazon")
public class CategoryController {

    private final ICreateCategoryUseCase iCreateCategoryUseCase;

    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory(@Valid @RequestBody CategoryDTO category){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCreateCategoryUseCase.createCategory(category));
//        CategoryDTO createdCategory = iCreateCategoryUseCase.createCategory(category);
//        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
}
