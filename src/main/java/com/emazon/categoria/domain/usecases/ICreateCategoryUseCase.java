package com.emazon.categoria.domain.usecases;

import com.emazon.categoria.infrastructure.dto.CategoryDTO;

public interface ICreateCategoryUseCase {
    CategoryDTO createCategory(CategoryDTO category);
}
