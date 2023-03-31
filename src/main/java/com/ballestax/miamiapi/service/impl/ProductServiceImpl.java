package com.ballestax.miamiapi.service.impl;


import com.ballestax.miamiapi.dto.ProductDto;
import com.ballestax.miamiapi.exception.ResourceNotFoundException;
import com.ballestax.miamiapi.mapper.ProductMapper;
import com.ballestax.miamiapi.model.Product;
import com.ballestax.miamiapi.repository.ProductRepository;
import com.ballestax.miamiapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.entityToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(()->
                new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public List<ProductDto> getProductsByLocation(Long id) {
        return productRepository.findAllByLocation(id)
                .stream()
                .map(product -> mapper.entityToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id)
        );
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setEnabled(product.isEnabled());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void delete(long id) {
        productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }

}
