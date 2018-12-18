package cn.zxh.jdbc;
/**
 * 连接池版本的数据库连接管理工具类适合于并发场合
 * @author developer
 *
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import cn.zxh.jdbc.day01.DbUtils;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static int initSize;
	private static int maxActive;
	private static int maxIdle;
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		Properties properties = new Properties();
		try {
			properties.load(DbUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			// 初始化参数
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			initSize = Integer.parseInt(properties.getProperty("initSize"));
			maxActive = Integer.parseInt(properties.getProperty("maxActive"));
			maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));
			// 初始化连接参数
			ds.setDriverClassName(driver); 
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setMaxIdle(maxIdle);
			ds.setInitialSize(initSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void rollback(Connection conn) {
		if(conn !=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
