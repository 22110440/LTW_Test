package com.ltw.test.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);

		boolean isLoggedIn = session != null && session.getAttribute("currentUser") != null;
		boolean isAdmin = Boolean.TRUE.equals(request.getSession(false) != null ? request.getSession(false).getAttribute("isAdmin") : null);

		if (!isLoggedIn) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		if (!isAdmin) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}

		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}
}


