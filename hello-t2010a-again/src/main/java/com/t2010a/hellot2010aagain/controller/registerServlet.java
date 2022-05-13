package com.t2010a.hellot2010aagain.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String tel = req.getParameter("tel");
        String gender = req.getParameter("gender");
        req.setAttribute("username", username);
        req.setAttribute("password", "*******");
        req.setAttribute("email", email);
        req.setAttribute("address", address);
        req.setAttribute("tel", tel);
        req.setAttribute("gender", gender);
        req.getRequestDispatcher("/register-success.jsp").forward(req, resp);
    }
}