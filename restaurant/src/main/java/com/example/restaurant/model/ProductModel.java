package com.example.restaurant.model;

import com.example.restaurant.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product obj); // lưu thông tin.

    List<Product> findAll();

    Product findById(int id);

    Product findByName(String name);

    List<Product> findByCategoryId(int categoryId);

    Product update(int id, Product updateObj);

    boolean delete(int id);
}
