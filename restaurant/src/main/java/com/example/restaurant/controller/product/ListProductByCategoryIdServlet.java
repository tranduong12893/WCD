package com.example.restaurant.controller.product;

import com.example.restaurant.HelloServlet;
import com.example.restaurant.entity.Category;
import com.example.restaurant.entity.Product;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.MySqlCategoryModel;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductByCategoryIdServlet extends HelloServlet {

    private ProductModel productModel;

    private CategoryModel categoryModel;

    public ListProductByCategoryIdServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Product> list = productModel.findByCategoryId(categoryId);
        request.setAttribute("title", "List Product");
        request.setAttribute("list", list);
        request.setAttribute("i", categoryId);
        try {
            request.getRequestDispatcher("/template/products/list.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
