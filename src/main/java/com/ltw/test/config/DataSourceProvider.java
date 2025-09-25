package com.ltw.test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public final class DataSourceProvider {
	private static volatile HikariDataSource dataSource;

	private DataSourceProvider() {}

	public static DataSource getDataSource() {
		if (dataSource == null) {
			synchronized (DataSourceProvider.class) {
				if (dataSource == null) {
					HikariConfig config = new HikariConfig();
					config.setJdbcUrl("jdbc:mysql://localhost:3306/ltw_qt?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
					config.setUsername("root");
					config.setPassword("123456");
					config.setDriverClassName("com.mysql.cj.jdbc.Driver");
					config.setMaximumPoolSize(10);
					config.setMinimumIdle(2);
					config.setPoolName("AppHikariPool");
					dataSource = new HikariDataSource(config);
				}
			}
		}
		return dataSource;
	}

	public static void close() {
		if (dataSource != null) {
			dataSource.close();
		}
	}
}


