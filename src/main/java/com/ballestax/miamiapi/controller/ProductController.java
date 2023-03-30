package com.ballestax.miamiapi.controller;


import com.ballestax.miamiapi.model.Presentation;
import com.ballestax.miamiapi.model.Product;
import com.ballestax.miamiapi.service.PresentationService;
import com.ballestax.miamiapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://miamibeachmaicao.netlify.app")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    private PresentationService presentationService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }


    @GetMapping("{id}/presentations")
    public List<Presentation> getPresentationsByProductId(@PathVariable("id") long id) {
        if (presentationService == null) {
            return Collections.emptyList();
        }
        return presentationService.getAllPresentationsByProductId(id);
    }

}
