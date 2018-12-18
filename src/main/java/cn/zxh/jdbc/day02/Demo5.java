package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.zxh.jdbc.DBUtils;

public class Demo5 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "update jdbctest set name=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "hua");
			ps.setInt(2, 1);
			System.out.println(ps.executeUpdate());
			ps.setString(1,"zhang");
			ps.setInt(2,1);
			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}

}
