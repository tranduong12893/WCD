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

public class ListProductServlet extends HttpServlet {

    private ProductModel productModel;


    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productModel.findAll();
        req.setAttribute("title", "List Product");
        req.setAttribute("list", list);
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
