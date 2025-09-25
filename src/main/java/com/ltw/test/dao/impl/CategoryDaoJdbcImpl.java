package com.ltw.test.dao.impl;

import com.ltw.test.config.DataSourceProvider;
import com.ltw.test.dao.CategoryDao;
import com.ltw.test.model.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoJdbcImpl implements CategoryDao {
	private final DataSource ds = DataSourceProvider.getDataSource();

	@Override
	public Category findById(Long id) {
		String sql = "SELECT CategoryId, CategoryName, CategoryCode, Images, Status FROM Category WHERE CategoryId=?";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return map(rs); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return null;
	}

	@Override
	public Category findByCode(String code) {
		String sql = "SELECT CategoryId, CategoryName, CategoryCode, Images, Status FROM Category WHERE CategoryCode=?";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, code);
			try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return map(rs); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return null;
	}

	@Override
	public List<Category> findAll() {
		String sql = "SELECT CategoryId, CategoryName, CategoryCode, Images, Status FROM Category WHERE Status=TRUE ORDER BY CategoryName";
		List<Category> list = new ArrayList<>();
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) list.add(map(rs));
		} catch (SQLException e) { throw new RuntimeException(e); }
		return list;
	}

	@Override
	public void save(Category c) {
		String sql = "INSERT INTO Category(CategoryName, CategoryCode, Images, Status) VALUES(?,?,?,?)";
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setString(1, c.getCategoryName());
			ps.setString(2, c.getCategoryCode());
			ps.setString(3, c.getImages());
			ps.setBoolean(4, c.isStatus());
			ps.executeUpdate();
		} catch (SQLException e) { throw new RuntimeException(e); }
	}

	@Override
	public void update(Category c) {
		String sql = "UPDATE Category SET CategoryName=?, CategoryCode=?, Images=?, Status=? WHERE CategoryId=?";
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setString(1, c.getCategoryName());
			ps.setString(2, c.getCategoryCode());
			ps.setString(3, c.getImages());
			ps.setBoolean(4, c.isStatus());
			ps.setLong(5, c.getCategoryId());
			ps.executeUpdate();
		} catch (SQLException e) { throw new RuntimeException(e); }
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM Category WHERE CategoryId=?";
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) { throw new RuntimeException(e); }
	}
	@Override
	public long countVideosByCategory(Long categoryId) {
		String sql = "SELECT COUNT(*) FROM Videos WHERE CategoryId=? AND Active=TRUE";
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setLong(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) return rs.getLong(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0L;
	}

	@Override
	public List<Category> findPage(int pageIndex, int pageSize) {
		String sql = "SELECT CategoryId, CategoryName, CategoryCode, Images, Status FROM Category ORDER BY CategoryName LIMIT ? OFFSET ?";
		List<Category> list = new ArrayList<>();
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setInt(1, pageSize);
			ps.setInt(2, pageIndex * pageSize);
			try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return list;
	}

	@Override
	public long countAll() {
		String sql = "SELECT COUNT(*) FROM Category";
		try (Connection cn = ds.getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) return rs.getLong(1);
			return 0L;
		} catch (SQLException e) { throw new RuntimeException(e); }
	}

	private Category map(ResultSet rs) throws SQLException {
		Category c = new Category();
		c.setCategoryId(rs.getLong("CategoryId"));
		c.setCategoryName(rs.getString("CategoryName"));
		c.setCategoryCode(rs.getString("CategoryCode"));
		c.setImages(rs.getString("Images"));
		c.setStatus(rs.getBoolean("Status"));
		return c;
	}
}


