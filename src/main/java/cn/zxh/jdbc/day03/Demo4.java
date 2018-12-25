package cn.zxh.jdbc.day03;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import cn.zxh.jdbc.DBUtils;

public class Demo4 {
	public static void main(String[] args) {
		String sql1 = "insert into log_01(id,msg) values(1,'zhang')";
		String sql2 = "insert into log_01(id,msg) values(2,'zhang2')";;
		String sql3 = "insert into log_01(id,msg) values(3,'zhang3')";;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			Statement st = conn.createStatement();
			// sql1添加到statement的缓存区
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			int[] array = st.executeBatch();
			System.out.println(Arrays.toString(array));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}
}
