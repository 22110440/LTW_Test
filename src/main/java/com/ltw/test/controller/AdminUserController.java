package com.ltw.test.controller;

import com.ltw.test.model.User;
import com.ltw.test.service.UserService;
import com.ltw.test.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/users", "/admin/users/create", "/admin/users/edit", "/admin/users/delete"})
public class AdminUserController extends HttpServlet {
	private final UserService userService = new UserServiceImpl();
	private static final int PAGE_SIZE = 6;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.endsWith("create")) {
			forwardForm(req, resp, new User());
			return;
		}
		if (uri.endsWith("edit")) {
			String username = req.getParameter("username");
			User user = userService.getByUsername(username);
			forwardForm(req, resp, user);
			return;
		}
		if (uri.endsWith("delete")) {
			String username = req.getParameter("username");
			if (username != null) userService.delete(username);
			resp.sendRedirect(req.getContextPath() + "/admin/users");
			return;
		}
		int page = parseInt(req.getParameter("page"), 0);
		List<User> users = userService.getUsersPage(page, PAGE_SIZE);
		long total = userService.countUsers();
		long totalPages = (long) Math.ceil(total / (double) PAGE_SIZE);
		req.setAttribute("users", users);
		req.setAttribute("page", page);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("pageTitle", "Quản trị Users");
		req.setAttribute("view", "/WEB-INF/views/admin/users/list.jsp");
		req.getRequestDispatcher("/WEB-INF/decorators/admin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		boolean admin = "on".equals(req.getParameter("admin"));
		boolean active = "on".equals(req.getParameter("active"));

		User user = userService.getByUsername(username);
		if (uri.endsWith("create")) {
			if (user != null) {
				req.setAttribute("error", "Username đã tồn tại");
				forwardForm(req, resp, new User());
				return;
			}
			user = new User();
			user.setUsername(username);
			user.setPasswordHash(password);
			user.setFullName(fullName);
			user.setEmail(email);
			user.setPhone(phone);
			user.setAdmin(admin);
			user.setActive(active);
			userService.create(user);
			resp.sendRedirect(req.getContextPath() + "/admin/users");
			return;
		}

		if (uri.endsWith("edit")) {
			if (user == null) {
				req.setAttribute("error", "User không tồn tại");
				forwardForm(req, resp, new User());
				return;
			}
			if (password != null && !password.isEmpty()) user.setPasswordHash(password);
			user.setFullName(fullName);
			user.setEmail(email);
			user.setPhone(phone);
			user.setAdmin(admin);
			user.setActive(active);
			userService.update(user);
			resp.sendRedirect(req.getContextPath() + "/admin/users");
			return;
		}
	}

	private void forwardForm(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
		req.setAttribute("item", user);
		req.setAttribute("pageTitle", user.getUsername() == null ? "Thêm User" : "Sửa User");
		req.setAttribute("view", "/WEB-INF/views/admin/users/form.jsp");
		req.getRequestDispatcher("/WEB-INF/decorators/admin.jsp").forward(req, resp);
	}

	private int parseInt(String s, int def) {
		try { return Integer.parseInt(s); } catch (Exception e) { return def; }
	}
}


