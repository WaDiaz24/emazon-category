package com.emazon.categoria.infrastructure.persistence.repository;

import com.emazon.categoria.infrastructure.persistence.entities.CategoryEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
