package com.emazon.categoria.domain.service;

import com.emazon.categoria.domain.exception.CategoryInvalidException;
import com.emazon.categoria.infrastructure.dto.CategoryDTO;
import com.emazon.categoria.infrastructure.mapper.CategoryMapper;
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
        var existingCategoryByName = iCategoryRepository.findByName(categoryDto.name());
        if(existingCategoryByName.isPresent()){
            throw new CategoryInvalidException("El nombre de la categoría ya existe");
        }
        Category category = categoryMapper.toEntity(categoryDto);
        System.out.println("HOLAA");
        System.out.println(category.getName());
        System.out.println(category.getDescription());
        Category savedCategory = iCategoryRepository.save(category);

        return categoryMapper.toDto(savedCategory);
    }
}
