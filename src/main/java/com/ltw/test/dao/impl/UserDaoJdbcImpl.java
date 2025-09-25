package com.ltw.test.dao.impl;

import com.ltw.test.config.DataSourceProvider;
import com.ltw.test.dao.UserDao;
import com.ltw.test.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoJdbcImpl implements UserDao {
	private final DataSource dataSource = DataSourceProvider.getDataSource();

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT Username, Password AS PasswordHash, Phone, Fullname, Email, Admin, Active, Images FROM Users WHERE Username = ?";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return mapRow(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public boolean existsByEmail(String email) {
		String sql = "SELECT 1 FROM Users WHERE Email = ?";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO Users(Username, Password, Phone, Fullname, Email, Admin, Active, Images) VALUES(?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPasswordHash());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getEmail());
			ps.setBoolean(6, user.isAdmin());
			ps.setBoolean(7, user.isActive());
			ps.setString(8, user.getImages());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE Users SET Password=?, Phone=?, Fullname=?, Email=?, Admin=?, Active=?, Images=? WHERE Username=?";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user.getPasswordHash());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getEmail());
			ps.setBoolean(5, user.isAdmin());
			ps.setBoolean(6, user.isActive());
			ps.setString(7, user.getImages());
			ps.setString(8, user.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteByUsername(String username) {
		String sql = "DELETE FROM Users WHERE Username=?";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public java.util.List<User> findPage(int pageIndex, int pageSize) {
		String sql = "SELECT Username, Password AS PasswordHash, Phone, Fullname, Email, Admin, Active, Images FROM Users ORDER BY Username LIMIT ? OFFSET ?";
		java.util.List<User> list = new java.util.ArrayList<>();
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, pageSize);
			ps.setInt(2, pageIndex * pageSize);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) list.add(mapRow(rs));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public long countAll() {
		String sql = "SELECT COUNT(*) FROM Users";
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			if (rs.next()) return rs.getLong(1);
			return 0L;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private User mapRow(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUsername(rs.getString("Username"));
		u.setPasswordHash(rs.getString("PasswordHash"));
		u.setPhone(rs.getString("Phone"));
		u.setFullName(rs.getString("Fullname"));
		u.setEmail(rs.getString("Email"));
		u.setAdmin(rs.getBoolean("Admin"));
		u.setActive(rs.getBoolean("Active"));
		u.setImages(rs.getString("Images"));
		return u;
	}
}


