package com.emazon.categoria.domain.service;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.application.mapper.CategoryMapper;
import com.emazon.categoria.domain.repository.ICategoryRepository;
import com.emazon.categoria.domain.usecases.IGetCategoryByName;

import java.util.Optional;

public class GetCategoryByNameService implements IGetCategoryByName {

    private final ICategoryRepository iCategoryRepository;
    private final CategoryMapper categoryMapper;

    public GetCategoryByNameService(ICategoryRepository iCategoryRepository, CategoryMapper categoryMapper) {
        this.iCategoryRepository = iCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Optional<CategoryDTO> getCategoryByName(String name) {
        return iCategoryRepository.findByName(name)
                .map(categoryMapper::toDto);
    }
}
