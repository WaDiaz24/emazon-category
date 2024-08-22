package com.emazon.categoria.domain.model;

import com.emazon.categoria.domain.exception.CategoryInvalidException;

import java.util.Objects;

public class Category {
    private Long id;
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
       validateName(name);
       validateDescription(description);
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {return id; }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void validateName(String name) {
        if (name == null ) {
            throw new CategoryInvalidException("El nombre no puede estar vacío");
            
        }
        if (name.length() > 50) {
            throw new CategoryInvalidException("El nombre no puede tener más de 50 caracteres");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new CategoryInvalidException("La descripción no puede estar vacía");
        }
        if (description.length() > 90) {
            throw new CategoryInvalidException("La descripción no puede tener más de 90 caracteres");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
