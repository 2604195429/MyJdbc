package cn.zxh.jdbc.day03;

import java.sql.Connection;
import java.sql.SQLException;

import cn.zxh.jdbc.DBUtils;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			//sql....
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			DBUtils.rollback(conn);
		}finally {
			DBUtils.close(conn);
		}
	}

}
