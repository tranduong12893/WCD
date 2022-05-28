package com.example.restaurant.controller.product;

import com.example.restaurant.entity.Product;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {

    private ProductModel productModel;

    public DeleteProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/template/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = productModel.delete(id);
            if (result) {
                resp.sendRedirect("/products/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/template/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
