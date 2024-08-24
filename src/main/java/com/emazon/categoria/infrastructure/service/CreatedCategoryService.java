package com.emazon.categoria.infrastructure.service;

import com.emazon.categoria.infrastructure.dto.CategoryDTO;
import com.emazon.categoria.infrastructure.mapper.CategoryMapper;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;
import com.emazon.categoria.infrastructure.persistence.entities.CategoryEntity;
import com.emazon.categoria.infrastructure.persistence.repository.JpaCategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CreatedCategoryService{

    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;
    private final ICreateCategoryUseCase cleanCreateCategoryUseCase;

    public CreatedCategoryService(JpaCategoryRepository jpaCategoryRepository, CategoryMapper categoryMapper, ICreateCategoryUseCase cleanCreateCategoryUseCase) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryMapper = categoryMapper;
        this.cleanCreateCategoryUseCase = cleanCreateCategoryUseCase;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        CategoryDTO cleanCategoryDTO = cleanCreateCategoryUseCase.createCategory(categoryDTO);

        Category category = categoryMapper.toEntity(cleanCategoryDTO);
        

        CategoryEntity categoryE = categoryMapper.toEntity(category);
     

        CategoryEntity savedCategoryE = jpaCategoryRepository.save(categoryE);
  
        Category savedCategory = categoryMapper.toModel(savedCategoryE);
    

        return categoryMapper.toDto(savedCategory);
    }
}
