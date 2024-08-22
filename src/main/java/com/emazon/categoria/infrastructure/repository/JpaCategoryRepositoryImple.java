package com.emazon.categoria.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.emazon.categoria.application.mapper.CategoryMapper;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.domain.repository.ICategoryRepository;
import com.emazon.categoria.infrastructure.entities.CategoryEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JpaCategoryRepositoryImple implements ICategoryRepository{

    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Optional<Category> findById(Long id) {
        return jpaCategoryRepository.findById(id).map(categoryMapper::toModel);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return jpaCategoryRepository.findByName(name).map(categoryMapper::toModel);
    }

    @Override
    public Category save(Category category) {
            CategoryEntity entity = categoryMapper.toEntity(category);
        return categoryMapper.toModel(jpaCategoryRepository.save(entity));
        }
    
}
