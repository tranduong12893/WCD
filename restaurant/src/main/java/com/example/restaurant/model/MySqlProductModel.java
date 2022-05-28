package com.example.restaurant.model;

import com.example.restaurant.entity.Product;
import com.example.restaurant.entity.myenum.CategoryStatus;
import com.example.restaurant.entity.myenum.ProductStatus;
import com.example.restaurant.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {

    @Override
    public Product save(Product obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into foods " +
                    "(name, categoryId, description, thumbnail, price, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getCategoryId());
            preparedStatement.setString(3, obj.getDescription());
            preparedStatement.setString(4, obj.getThumbnail());
            preparedStatement.setDouble(5, obj.getPrice());
            preparedStatement.setString(6, obj.getCreatedAt().toString());
            preparedStatement.setString(7, obj.getUpdatedAt().toString());
            preparedStatement.setInt(8, obj.getStatus().getValue());
            preparedStatement.execute();
            System.out.println("Action success!");
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foods where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                Product obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
                list.add(obj);
            }
            System.out.println("Action success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Action success!");
        return list;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foods where status = ? and categoryId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                Product obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
                list.add(obj);
            }
            System.out.println("Action success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(int id) {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foods where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
            }
            System.out.println("Action success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Product findByName(String name) {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from foods where status = ? and name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                obj = new Product();
                obj.setId(id);
                obj.setCategoryId(categoryId);
                obj.setName(name);
                obj.setDescription(description);
                obj.setThumbnail(thumbnail);
                obj.setPrice(price);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(ProductStatus.of(intStatus));
            }
            System.out.println("Action success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Product update(int id, Product updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update foods " +
                    "set  name = ?, categoryId = ?, description = ?, thumbnail = ?, price = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setInt(2, updateObj.getCategoryId());
            preparedStatement.setString(3, updateObj.getDescription());
            preparedStatement.setString(4, updateObj.getThumbnail());
            preparedStatement.setDouble(5, updateObj.getPrice());
            preparedStatement.setString(6, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(7, updateObj.getStatus().getValue());
            preparedStatement.setInt(8, id);
            preparedStatement.execute();
            System.out.println("Action success!");
            return updateObj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update foods " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ProductStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            System.out.println("Action success!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
