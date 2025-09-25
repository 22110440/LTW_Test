package com.ltw.test.dao;

import com.ltw.test.model.User;

public interface UserDao {
	User findByUsername(String username);
	boolean existsByEmail(String email);
	void save(User user);
	void update(User user);
	void deleteByUsername(String username);
	java.util.List<User> findPage(int pageIndex, int pageSize);
	long countAll();
}


