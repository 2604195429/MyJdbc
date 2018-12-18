package cn.zxh.jdbc.day01;

import java.sql.Connection;

public class Demo6 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DbUtils.close(conn);
		}
	}
}
