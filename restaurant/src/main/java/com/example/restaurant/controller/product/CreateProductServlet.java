package com.example.restaurant.controller.product;

import com.example.restaurant.entity.Product;
import com.example.restaurant.entity.myenum.ProductStatus;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.MySqlCategoryModel;
import com.example.restaurant.model.MySqlProductModel;
import com.example.restaurant.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public CreateProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category", categoryModel.findAll());
        req.setAttribute("obj", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int status = Integer.parseInt(req.getParameter("status"));
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product();
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setStatus(ProductStatus.of(status));
        product.setThumbnail(thumbnail);
        product.setDescription(description);
        product.setPrice(price);

        if (!product.isValid()) {
            if (productModel.findByName(name) == null) {
                req.setAttribute("category", categoryModel.findAll());
                req.setAttribute("obj", product);
                req.setAttribute("title", "Create Product");
                req.setAttribute("action", 1);
                req.setAttribute("errors", product.getErrors());
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
                return;
            }
            product.addErrors("name2", "Tên món ăn đã có hãy lấy tên khác!");
        }
        if (productModel.save(product) != null) {
            resp.sendRedirect("/products/list");
        } else {
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }
}
