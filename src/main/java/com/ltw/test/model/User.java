package com.ltw.test.model;

public class User {
	private String username;
	private String passwordHash;
	private String phone;
	private String fullName;
	private String email;
	private boolean admin;
	private boolean active;
	private String images;

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPasswordHash() { return passwordHash; }
	public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getFullName() { return fullName; }
	public void setFullName(String fullName) { this.fullName = fullName; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public boolean isAdmin() { return admin; }
	public void setAdmin(boolean admin) { this.admin = admin; }

	public boolean isActive() { return active; }
	public void setActive(boolean active) { this.active = active; }

	public String getImages() { return images; }
	public void setImages(String images) { this.images = images; }
}


