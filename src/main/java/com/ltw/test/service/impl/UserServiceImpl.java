package com.ltw.test.service.impl;

import com.ltw.test.dao.UserDao;
import com.ltw.test.dao.impl.UserDaoJdbcImpl;
import com.ltw.test.model.User;
import com.ltw.test.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJdbcImpl();

    public UserServiceImpl() {
        // seed admin nếu chưa có
        // Seed admin nếu chưa tồn tại (mật khẩu plaintext demo)
        if (userDao.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPasswordHash("admin");
            admin.setFullName("Administrator");
            admin.setEmail("admin@example.com");
            admin.setPhone("");
            admin.setAdmin(true);
            admin.setActive(true);
            userDao.save(admin);
        }
    }

	@Override
	public User authenticate(String username, String rawPassword) {
		User user = userDao.findByUsername(username);
		if (user == null) return null;
		return user.getPasswordHash().equals(rawPassword) && user.isActive() ? user : null;
	}

	@Override
	public User register(String username, String rawPassword, String fullName, String email, String phone) {
        if (userDao.findByUsername(username) != null || userDao.existsByEmail(email)) {
            return null;
        }
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(rawPassword);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAdmin(false);
        user.setActive(true);
        userDao.save(user);
        return user;
	}

	@Override
	public java.util.List<User> getUsersPage(int pageIndex, int pageSize) {
		return userDao.findPage(pageIndex, pageSize);
	}

	@Override
	public long countUsers() {
		return userDao.countAll();
	}

	@Override
	public User getByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void create(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(String username) {
		userDao.deleteByUsername(username);
	}
}


