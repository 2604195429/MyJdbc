package cn.zxh.jdbc.day02;

import java.sql.Connection;

import cn.zxh.jdbc.DBUtils;

public class Demo6 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
