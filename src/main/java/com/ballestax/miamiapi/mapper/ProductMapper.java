package com.ballestax.miamiapi.mapper;

import com.ballestax.miamiapi.dto.ProductDto;
import com.ballestax.miamiapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.name", target = "category")
    ProductDto entityToDto(Product entity);
    List<ProductDto> entityListToToDtoList(List<Product> entityList);


    @Mapping(target = "category", ignore = true)
    Product dtoToEntity(ProductDto dto);

    List<Product> dtoListToEntityList(List<ProductDto> dtoList);


}
