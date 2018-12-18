package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.zxh.jdbc.DBUtils;

public class Demo2 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from jdbctest");
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}

}
