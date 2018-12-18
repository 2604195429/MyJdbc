package cn.zxh.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils02 {
	private static BasicDataSource ds;
	private static int maxIdle;
	private static int maxActive;
	private static int initSize;
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		ds = new BasicDataSource();
		try {
			Properties properties = new Properties();
			properties.load(DBUtils02.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			maxActive = Integer.parseInt(properties.getProperty("maxActive"));
			maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));
			initSize = Integer.parseInt(properties.getProperty("initSize"));
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setPassword(password);
			ds.setUsername(username);
			ds.setMaxActive(maxActive);
			ds.setMaxIdle(maxIdle);
			ds.setInitialSize(initSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConntion() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
