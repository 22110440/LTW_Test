package com.ltw.test.controller;

import com.ltw.test.dao.CategoryDao;
import com.ltw.test.dao.impl.CategoryDaoJdbcImpl;
import com.ltw.test.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/categories")
public class CategoryController extends HttpServlet {
	private final CategoryDao categoryDao = new CategoryDaoJdbcImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy danh sách categories
		List<Category> categories = categoryDao.findAll();

		// Gán thêm số lượng video cho từng category
		for (Category c : categories) {
			long count = categoryDao.countVideosByCategory(c.getCategoryId());
			c.setVideoCount(count);
		}

		// Gửi dữ liệu sang JSP
		req.setAttribute("categories", categories);
		req.setAttribute("pageTitle", "Danh mục");
		req.setAttribute("view", "/WEB-INF/views/category/list.jsp");

		// Forward sau khi set đủ dữ liệu
		req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
	}
}
