package cn.zxh.jdbc.day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	// ��ȡ�ļ��е����ݿ����Ӳ���
	static {
		// ��ʼ����̬����
		Properties properties = new Properties();
		try {
			properties.load(DbUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			System.out.println(properties);
			// ��ʼ�� ���Ӳ���
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��װ�������ݿ����ӵĹ��� �����ݿ�����
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void close(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
