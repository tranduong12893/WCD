package com.example.restaurant.controller.category;

import com.example.restaurant.entity.Category;
import com.example.restaurant.model.MySqlCategoryModel;
import com.example.restaurant.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCategoryServlet extends HttpServlet {

    private CategoryModel categoryModel;

    public ListCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> list = categoryModel.findAll();
        req.setAttribute("title", "List Category");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/template/category/list.jsp").forward(req, resp);
    }
}
