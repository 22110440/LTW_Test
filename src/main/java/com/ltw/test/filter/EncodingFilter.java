package com.ltw.test.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // nhớ thêm annotation này hoặc cấu hình trong web.xml
public class EncodingFilter implements Filter {
	private static final String UTF_8 = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// không cần gì thêm
	}

	@Override
	public void doFilter(ServletRequest request,
						 ServletResponse response,
						 FilterChain chain)
			throws IOException, ServletException {
		// chỉ set nếu chưa có
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(UTF_8);
		}
		response.setCharacterEncoding(UTF_8);
		response.setContentType("text/html; charset=" + UTF_8);

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// không cần gì thêm
	}
}
