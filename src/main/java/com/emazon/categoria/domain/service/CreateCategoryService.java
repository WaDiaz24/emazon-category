package com.emazon.categoria.domain.service;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.application.mapper.CategoryMapper;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.repository.ICategoryRepository;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;


public class CreateCategoryService implements ICreateCategoryUseCase {

    private final ICategoryRepository iCategoryRepository;
    private final CategoryMapper categoryMapper;

    public CreateCategoryService(ICategoryRepository iCategoryRepository, CategoryMapper categoryMapper) {
        this.iCategoryRepository = iCategoryRepository;
        this.categoryMapper = categoryMapper;
      
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) {
        System.out.println("Estoy en el servicio limpio");
        Category category = categoryMapper.toEntity(categoryDto);
        System.out.println("Hola");
        Category savedCategory = iCategoryRepository.save(category);

        return categoryMapper.toDto(savedCategory);
    }
}
