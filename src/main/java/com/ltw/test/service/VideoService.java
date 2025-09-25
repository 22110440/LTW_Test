package com.ltw.test.service;

import com.ltw.test.model.Category;
import com.ltw.test.model.Video;
import java.util.List;

public interface VideoService {
	Video getDetail(Long id);
	Category getCategoryOf(Video v);
	List<Video> getVideosByCategoryCode(String categoryCode);
	Category getCategoryByCode(String categoryCode);
	int getLikeCount(Long videoId);
	int getShareCount(Long videoId);
	void increaseViews(Long videoId);
}


