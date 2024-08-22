package com.emazon.categoria.application.mapper;

import com.emazon.categoria.application.dto.CategoryDTO;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Mapea de entidad a DTO
    CategoryDTO toDto(Category category);

    // Mapea de DTO a entidad
    Category toEntity(CategoryDTO categoryDTO);

    CategoryEntity toEntity(Category category);

    Category toModel(CategoryEntity categoryEntity);
}
