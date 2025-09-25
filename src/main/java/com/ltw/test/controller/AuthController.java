package com.ltw.test.controller;

import com.ltw.test.model.User;
import com.ltw.test.service.UserService;
import com.ltw.test.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/register", "/logout"})
public class AuthController extends HttpServlet {
	private final UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
        if (uri.endsWith("register")) {
            req.setAttribute("pageTitle", "Đăng ký");
            req.setAttribute("view", "/WEB-INF/views/register.jsp");
            req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
            return;
        }
		if (uri.endsWith("logout")) {
			HttpSession session = req.getSession(false);
			if (session != null) session.invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
        req.setAttribute("pageTitle", "Đăng nhập");
        req.setAttribute("view", "/WEB-INF/views/login.jsp");
        req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.endsWith("register")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			User user = userService.register(username, password, fullname, email, phone);
            if (user == null) {
                req.setAttribute("error", "Tài khoản hoặc email đã tồn tại");
                req.setAttribute("pageTitle", "Đăng ký");
                req.setAttribute("view", "/WEB-INF/views/register.jsp");
                req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
                return;
            }
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.authenticate(username, password);
        if (user == null) {
            req.setAttribute("error", "Sai thông tin đăng nhập");
            req.setAttribute("pageTitle", "Đăng nhập");
            req.setAttribute("view", "/WEB-INF/views/login.jsp");
            req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
            return;
        }
		HttpSession session = req.getSession(true);
		session.setAttribute("currentUser", user);
		session.setAttribute("isAdmin", user.isAdmin());
		resp.sendRedirect(req.getContextPath() + "/");
	}
}


