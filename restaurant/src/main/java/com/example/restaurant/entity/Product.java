package com.example.restaurant.entity;

import com.example.restaurant.entity.base.BaseEntity;
import com.example.restaurant.entity.myenum.ProductStatus;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {

    private int id;
    private String name;
    private int categoryId;
    private String description;
    private String thumbnail;
    private double price;
    private ProductStatus status;

    public Product(String name, int categoryId, String description, String thumbnail, double price) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValidate();
        return errors.size() == 0;
    }
    public void addErrors(String key, String value) {
        if(this.errors == null){
            this.errors = new HashMap<>();
        }
        this.errors.put(key, value);
    }
    private void checkValidate() {
        // validate dữ liệu theo kiểu cùi bắp.
        if (name == null || name.length() == 0) {
            errors.put("name", "Hãy nhập tên món ăn!");
        }
        if (name.length() > 7){
            errors.put("name1", "Hãy nhập tên món ăn dài hơn 7 ký tự!");
        }
        if (price == 0) {
            errors.put("price", "Hãy nhập giá món ăn!");
        }
        if (thumbnail == null || thumbnail.length() == 0) {
            errors.put("thumbnail", "Hãy chèn ảnh món ăn vào!");
        }
        if (description == null || description.length() == 0){
            errors.put("description", "hãy Nhập thông tin gới thiệu về món ăn!");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    public Product() {
        this.name = "";
        this.description = "";
        this.price = 0;
        this.thumbnail = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
