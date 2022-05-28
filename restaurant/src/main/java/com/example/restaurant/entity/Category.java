package com.example.restaurant.entity;

import com.example.restaurant.entity.base.BaseEntity;
import com.example.restaurant.entity.myenum.CategoryStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Category extends BaseEntity {

    private int id;
    private String name;
    private CategoryStatus status;

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate(){

        if (name == null || name.length() == 0){
            errors.put("name", "Hãy nhập loại món ăn!");
        }
    }

    public  HashMap<String, String> getErrors(){
        return errors;
    }

    public void addErrors(String key, String value) {
        if(this.errors == null){
            this.errors = new HashMap<>();
        }
        this.errors.put(key, value);
    }

    public List<String> getListErrors() {
        return new ArrayList<>(errors.values());
    }

    public Category() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }
}
