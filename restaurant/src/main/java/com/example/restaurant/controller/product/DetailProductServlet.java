package com.example.restaurant.controller.product;

import com.example.restaurant.entity.Product;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.MySqlCategoryModel;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public DetailProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/template/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            ArrayList<Product> recentView =
                    (ArrayList<Product>) session.getAttribute("recentView");
            if(recentView == null){
                recentView = new ArrayList<Product>();
            }
            boolean exist = false;
            if(!exist){
                recentView.add(product);
                session.setAttribute("recentView", recentView);
            }
            req.setAttribute("category", categoryModel.findById(product.getCategoryId()));
            req.setAttribute("product", product);
            req.setAttribute("title", "Detail Product");
            req.getRequestDispatcher("/template/products/detail.jsp").forward(req, resp);
        }

    }
}
