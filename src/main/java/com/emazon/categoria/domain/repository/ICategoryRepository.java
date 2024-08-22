package com.emazon.categoria.domain.repository;

import com.emazon.categoria.domain.model.Category;

import java.util.Optional;

public interface ICategoryRepository {
    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);
    Category save(Category category);
}
