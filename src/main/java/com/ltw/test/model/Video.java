package com.ltw.test.model;

public class Video {
	private Long videoId;
	private String title;
	private String poster;
	private Integer views;
	private String description;
	private boolean active;
	private Long categoryId;

	public Long getVideoId() { return videoId; }
	public void setVideoId(Long videoId) { this.videoId = videoId; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getPoster() { return poster; }
	public void setPoster(String poster) { this.poster = poster; }

	public Integer getViews() { return views; }
	public void setViews(Integer views) { this.views = views; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }

	public Long getCategoryId() { return categoryId; }
	public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
	private long videoCount;
	public long getVideoCount() { return videoCount; }
	public void setVideoCount(long videoCount) { this.videoCount = videoCount; }
}


