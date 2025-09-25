package com.ltw.test.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminController extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageTitle", "Bảng điều khiển");
        req.setAttribute("view", "/WEB-INF/views/admin/dashboard.jsp");
        req.getRequestDispatcher("/WEB-INF/decorators/admin.jsp").forward(req, resp);
    }
}


