package com.ballestax.miamiapi.mapper;

import com.ballestax.miamiapi.dto.CategoryDto;
import com.ballestax.miamiapi.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto entityToDto(Category entity);

    Category dtoToEntity(CategoryDto dto);
}

