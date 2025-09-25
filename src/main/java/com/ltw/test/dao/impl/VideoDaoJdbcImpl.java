package com.ltw.test.dao.impl;

import com.ltw.test.config.DataSourceProvider;
import com.ltw.test.dao.VideoDao;
import com.ltw.test.model.Video;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDaoJdbcImpl implements VideoDao {
	private final DataSource ds = DataSourceProvider.getDataSource();

	@Override
	public Video findById(Long id) {
		String sql = "SELECT VideoId, Title, Poster, Views, Description, Active, CategoryId FROM Videos WHERE VideoId=? AND Active=TRUE";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return map(rs); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return null;
	}
	@Override
	public int countByCategory(Long categoryId) {
		String sql = "SELECT COUNT(*) FROM Videos WHERE CategoryId=? AND Active=TRUE";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}

	@Override
	public List<Video> findByCategoryId(Long categoryId) {
		String sql = "SELECT VideoId, Title, Poster, Views, Description, Active, CategoryId FROM Videos WHERE Active=TRUE AND CategoryId=? ORDER BY VideoId DESC";
		List<Video> list = new ArrayList<>();
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) { while (rs.next()) list.add(map(rs)); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return list;
	}

	@Override
	public int countLikes(Long videoId) {
		String sql = "SELECT COUNT(*) FROM Favorites WHERE VideoId=?";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, videoId);
			try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return rs.getInt(1); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return 0;
	}

	@Override
	public int countShares(Long videoId) {
		String sql = "SELECT COUNT(*) FROM Shares WHERE VideoId=?";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, videoId);
			try (ResultSet rs = ps.executeQuery()) { if (rs.next()) return rs.getInt(1); }
		} catch (SQLException e) { throw new RuntimeException(e); }
		return 0;
	}

	@Override
	public void increaseViews(Long videoId) {
		String sql = "UPDATE Videos SET Views = COALESCE(Views,0) + 1 WHERE VideoId=?";
		try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setLong(1, videoId);
			ps.executeUpdate();
		} catch (SQLException e) { throw new RuntimeException(e); }
	}

	private Video map(ResultSet rs) throws SQLException {
		Video v = new Video();
		v.setVideoId(rs.getLong("VideoId"));
		v.setTitle(rs.getString("Title"));
		v.setPoster(rs.getString("Poster"));
		v.setViews(rs.getInt("Views"));
		v.setDescription(rs.getString("Description"));
		v.setActive(rs.getBoolean("Active"));
		v.setCategoryId(rs.getLong("CategoryId"));
		return v;
	}
}


