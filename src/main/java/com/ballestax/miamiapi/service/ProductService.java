package com.ballestax.miamiapi.service;

import com.ballestax.miamiapi.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

}
