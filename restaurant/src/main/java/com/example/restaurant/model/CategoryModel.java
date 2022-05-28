package com.example.restaurant.model;

import com.example.restaurant.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category obj); // lưu thông tin.

    Category findByName(String name);

    Category findById(int id);

    List<Category> findAll();

    boolean delete(int id);
}
