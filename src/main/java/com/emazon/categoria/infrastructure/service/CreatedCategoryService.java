package com.emazon.categoria.infrastructure.service;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.application.mapper.CategoryMapper;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;
import com.emazon.categoria.infrastructure.entities.CategoryEntity;
import com.emazon.categoria.infrastructure.repository.JpaCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatedCategoryService{

    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;
    private final ICreateCategoryUseCase cleanCreateCategoryUseCase;

  
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        CategoryDTO cleanCategoryDTO = cleanCreateCategoryUseCase.createCategory(categoryDTO);

        Category category = categoryMapper.toEntity(cleanCategoryDTO);
        

        CategoryEntity categoryE = categoryMapper.toEntity(category);
     

        CategoryEntity savedCategoryE = jpaCategoryRepository.save(categoryE);
  
        Category savedCategory = categoryMapper.toModel(savedCategoryE);
    

        return categoryMapper.toDto(savedCategory);
    }
}
