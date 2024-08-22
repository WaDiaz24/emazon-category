package com.emazon.categoria.domain.service;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.application.mapper.CategoryMapper;
import com.emazon.categoria.domain.repository.ICategoryRepository;
import com.emazon.categoria.domain.usecases.IGetCategoryById;

import java.util.Optional;

public class GetCategoryByIdService implements IGetCategoryById {

    private final ICategoryRepository iCategoryRepository;
    private final CategoryMapper categoryMapper;

    public GetCategoryByIdService(ICategoryRepository iCategoryRepository, CategoryMapper categoryMapper) {
        this.iCategoryRepository = iCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Optional<CategoryDTO> getCategoryByid(Long id) {
        return iCategoryRepository.findById(id)
                .map(categoryMapper::toDto);
    }
}
