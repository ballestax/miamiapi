package com.ballestax.miamiapi.service;

import com.ballestax.miamiapi.dto.ProductDto;
import com.ballestax.miamiapi.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<ProductDto> getAllProducts();

    Product getProductById(long id);

    List<ProductDto> getProductsByLocation(Long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

}
