package cn.zxh.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		try {
			String driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "system";
			String password = "zxh001019";
			conn = DriverManager.getConnection(url, user, password);
			statement = conn.createStatement();
			String sql = "select * from jdbctest";
			ResultSet s = statement.executeQuery(sql);
			while (s.next()) {
				int  id = s.getInt("id");
				String name = s.getString("name");
				System.out.println(id + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
}
