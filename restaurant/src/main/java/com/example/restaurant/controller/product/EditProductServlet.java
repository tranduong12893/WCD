package com.example.restaurant.controller.product;

import com.example.restaurant.entity.Category;
import com.example.restaurant.entity.Product;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.MySqlCategoryModel;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        List<Category> category = categoryModel.findAll();
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            req.setAttribute("category", category);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/admin/products/edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct = productModel.findById(id);
        List<Category> category = categoryModel.findAll();
        if(existingProduct == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            String name = req.getParameter("name");
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            Product product = new Product(name, categoryId, description, thumbnail, price);
            if (!product.isValid()){
                if (productModel.findByName(name) == null){
                    if (productModel.update(id, product) != null) {
                        System.out.println(product);
                        resp.sendRedirect("/products/list");
                    } else {
                        req.setAttribute("category", category);
                        req.setAttribute("product", product);
                        req.setAttribute("title", "Edit product");
                        req.getRequestDispatcher("/admin/products/edit.jsp").forward(req, resp);
                    }
                }
            }
        }
    }
}
