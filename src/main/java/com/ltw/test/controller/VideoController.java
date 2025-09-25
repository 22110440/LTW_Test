package com.ltw.test.controller;

import com.ltw.test.model.Category;
import com.ltw.test.model.Video;
import com.ltw.test.service.VideoService;
import com.ltw.test.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/video/detail", "/video/by-category"})
public class VideoController extends HttpServlet {
	private final VideoService videoService = new VideoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.endsWith("detail")) {
			String idStr = req.getParameter("id");
			Long id = idStr != null ? Long.valueOf(idStr) : null;
			Video v = id != null ? videoService.getDetail(id) : null;
			if (v != null) {
				videoService.increaseViews(v.getVideoId());
				v.setViews(v.getViews() == null ? 1 : v.getViews() + 1);
			}
			Category c = videoService.getCategoryOf(v);
			int likeCount = v != null ? videoService.getLikeCount(v.getVideoId()) : 0;
			int shareCount = v != null ? videoService.getShareCount(v.getVideoId()) : 0;
			req.setAttribute("video", v);
			req.setAttribute("category", c);
			req.setAttribute("likeCount", likeCount);
			req.setAttribute("shareCount", shareCount);
			req.setAttribute("pageTitle", v != null ? v.getTitle() : "Chi tiết video");
			req.setAttribute("view", "/WEB-INF/views/video/detail.jsp");
			req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
			return;
		}

		String code = req.getParameter("code");
		List<Video> list = videoService.getVideosByCategoryCode(code);
		Category cat = videoService.getCategoryByCode(code);
		req.setAttribute("videos", list);
		req.setAttribute("categoryCode", code);
		req.setAttribute("categoryName", cat != null ? cat.getCategoryName() : null);
		req.setAttribute("pageTitle", "Danh sách video theo thể loại");
		req.setAttribute("view", "/WEB-INF/views/video/by-category.jsp");
		req.getRequestDispatcher("/WEB-INF/decorators/user.jsp").forward(req, resp);
	}
}


