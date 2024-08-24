package com.emazon.categoria.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emazon.categoria.infrastructure.mapper.CategoryMapper;
import com.emazon.categoria.domain.repository.ICategoryRepository;
import com.emazon.categoria.domain.service.CreateCategoryService;
import com.emazon.categoria.domain.usecases.ICreateCategoryUseCase;


@Configuration
public class CategoryServiceConfig {


   

    @Bean
    public ICreateCategoryUseCase createCategoryService(ICategoryRepository iCategoryRepository, CategoryMapper categoryMapper) {
        return new CreateCategoryService(iCategoryRepository, categoryMapper);
    }
}
