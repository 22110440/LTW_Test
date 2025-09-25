package com.ltw.test.dao.impl;

import com.ltw.test.dao.UserDao;
import com.ltw.test.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDaoImpl implements UserDao {
	private static final Map<String, User> USERS = new ConcurrentHashMap<>();

	@Override
	public User findByUsername(String username) {
		return USERS.get(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return USERS.values().stream().anyMatch(u -> email.equalsIgnoreCase(u.getEmail()));
	}

	@Override
	public void save(User user) {
		USERS.put(user.getUsername(), user);
	}

	@Override
	public void update(User user) {
		USERS.put(user.getUsername(), user);
	}

	@Override
	public void deleteByUsername(String username) {
		USERS.remove(username);
	}

	@Override
	public java.util.List<User> findPage(int pageIndex, int pageSize) {
		java.util.List<User> all = new java.util.ArrayList<>(USERS.values());
		all.sort(java.util.Comparator.comparing(User::getUsername));
		int from = Math.max(0, pageIndex * pageSize);
		int to = Math.min(all.size(), from + pageSize);
		if (from >= all.size()) return java.util.Collections.emptyList();
		return all.subList(from, to);
	}

	@Override
	public long countAll() {
		return USERS.size();
	}
}


