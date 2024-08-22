package com.emazon.categoria.domain.usecases;

import com.emazon.categoria.application.dto.CategoryDTO;

import java.util.Optional;

public interface IGetCategoryById {
    Optional<CategoryDTO> getCategoryByid(Long id);
}
