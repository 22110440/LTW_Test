package com.ltw.test.service.impl;

import com.ltw.test.dao.CategoryDao;
import com.ltw.test.dao.VideoDao;
import com.ltw.test.dao.impl.CategoryDaoJdbcImpl;
import com.ltw.test.dao.impl.VideoDaoJdbcImpl;
import com.ltw.test.model.Category;
import com.ltw.test.model.Video;
import com.ltw.test.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
	private final VideoDao videoDao = new VideoDaoJdbcImpl();
	private final CategoryDao categoryDao = new CategoryDaoJdbcImpl();

	@Override
	public Video getDetail(Long id) { return videoDao.findById(id); }

	@Override
	public Category getCategoryOf(Video v) { return v == null ? null : categoryDao.findById(v.getCategoryId()); }

	@Override
	public List<Video> getVideosByCategoryCode(String categoryCode) {
		Category c = categoryDao.findByCode(categoryCode);
		if (c == null) return java.util.Collections.emptyList();
		return videoDao.findByCategoryId(c.getCategoryId());
	}

	public Category getCategoryByCode(String categoryCode) { return categoryDao.findByCode(categoryCode); }

	@Override
	public int getLikeCount(Long videoId) { return videoDao.countLikes(videoId); }

	@Override
	public int getShareCount(Long videoId) { return videoDao.countShares(videoId); }

	@Override
	public void increaseViews(Long videoId) { videoDao.increaseViews(videoId); }
}


