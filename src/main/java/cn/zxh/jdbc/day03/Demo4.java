package cn.zxh.jdbc.day03;

import java.sql.Connection;
import java.sql.Statement;

import cn.zxh.jdbc.DBUtils;

/**
 * 执行一批DDL
 * 
 * @author developer
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		String sql1 = "create table log_01 (id number(8),msg varchar(100))";
		String sql2 = "create table log_02 (id number(8),msg varchar(100))";
		String sql3 = "create table log_03 (id number(8),msg varchar(100))";
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			Statement st = conn.createStatement();
			// sql1添加到statement的缓存区
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			int[] array = st.executeBatch();
			System.out.println(array);
		} catch (Exception e) {
			e.printStackTrace();
			DBUtils.rollback(conn);
		} finally {
			DBUtils.close(conn);
		}
	}

}
