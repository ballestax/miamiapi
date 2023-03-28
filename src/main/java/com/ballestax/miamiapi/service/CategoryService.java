package com.ballestax.miamiapi.service;


import com.ballestax.miamiapi.model.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(long id);

    Category updateCategory(Category category, long id);

    void delete(long id);
}
