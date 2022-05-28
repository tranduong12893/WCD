package com.example.restaurant.controller.category;


import com.example.restaurant.entity.Category;
import com.example.restaurant.entity.myenum.CategoryStatus;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public CreateCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cat", new Category());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/category/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int status = Integer.parseInt(req.getParameter("status"));
        Category category = new Category(name, status);
        category.setName(name);
        category.setStatus(CategoryStatus.of(status));
        if (categoryModel.findByName(name) != null){
            category.addErrors("name", "Hãy nhập loại món ăn!");
        }
        if (!category.isValid()){
            req.setAttribute("cat", category);
            req.setAttribute("action", 1);
            req.setAttribute("title", "Create Category");
            req.setAttribute("errors", category.getErrors());
            req.getRequestDispatcher("/admin/category/create.jsp").forward(req, resp);
            return;
        }
        if (categoryModel.save(category) != null) {
            resp.sendRedirect("/categories/list");
        } else {
            req.getRequestDispatcher("/admin/categories/create.jsp").forward(req, resp);
        }
    }
}
