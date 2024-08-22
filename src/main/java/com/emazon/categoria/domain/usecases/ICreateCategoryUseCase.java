package com.emazon.categoria.domain.usecases;

import com.emazon.categoria.application.dto.CategoryDTO;

public interface ICreateCategoryUseCase {
    CategoryDTO createCategory(CategoryDTO category);
}
