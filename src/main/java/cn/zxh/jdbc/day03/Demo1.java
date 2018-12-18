package cn.zxh.jdbc.day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import cn.zxh.jdbc.DBUtils;

/**
 * 结果集元数据
 * 
 * @author developer
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from jdbctest";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <=metaData.getColumnCount() ; i++) {
				System.out.println(i+" "+metaData.getColumnName(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}
}
