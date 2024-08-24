package com.emazon.categoria.infrastructure.mapper;

import com.emazon.categoria.infrastructure.dto.CategoryDTO;
import com.emazon.categoria.domain.model.Category;
import com.emazon.categoria.infrastructure.persistence.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Mapea de entidad a DTO
    CategoryDTO toDto(Category category);

    // Mapea de DTO a entidad
    Category toEntity(CategoryDTO categoryDTO);

    CategoryEntity toEntity(Category category);

    Category toModel(CategoryEntity categoryEntity);
}
