package com.ltw.test.model;

public class Category {
	private Long categoryId;
	private String categoryName;
	private String categoryCode;
	private String images;
	private boolean status;
	private long videoCount;


	public Long getCategoryId() { return categoryId; }
	public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

	public String getCategoryName() { return categoryName; }
	public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

	public String getCategoryCode() { return categoryCode; }
	public void setCategoryCode(String categoryCode) { this.categoryCode = categoryCode; }

	public String getImages() { return images; }
	public void setImages(String images) { this.images = images; }

	public boolean isStatus() { return status; }
	public void setStatus(boolean status) { this.status = status; }
	public long getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(long videoCount) {
		this.videoCount = videoCount;
	}
}


