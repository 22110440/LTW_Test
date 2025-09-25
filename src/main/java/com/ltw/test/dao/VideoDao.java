package com.ltw.test.dao;

import com.ltw.test.model.Video;
import java.util.List;

public interface VideoDao {
	Video findById(Long id);
	List<Video> findByCategoryId(Long categoryId);
	int countLikes(Long videoId);
	int countShares(Long videoId);
	void increaseViews(Long videoId);
	int countByCategory(Long categoryId);

}


