package com.ltw.test.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/", "/home", "/products"})
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
        if (uri.endsWith("products")) {
            req.setAttribute("pageTitle", "Sản phẩm");
            req.setAttribute("view", "/WEB-INF/views/products.jsp");
            req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("pageTitle", "Trang chủ");
        req.setAttribute("view", "/WEB-INF/views/home.jsp");
        req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
	}
}


