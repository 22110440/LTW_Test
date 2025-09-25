package com.ltw.test.service;

import com.ltw.test.model.User;

public interface UserService {
	User authenticate(String username, String rawPassword);
	User register(String username, String rawPassword, String fullName, String email, String phone);
	java.util.List<User> getUsersPage(int pageIndex, int pageSize);
	long countUsers();
	User getByUsername(String username);
	void create(User user);
	void update(User user);
	void delete(String username);
}


