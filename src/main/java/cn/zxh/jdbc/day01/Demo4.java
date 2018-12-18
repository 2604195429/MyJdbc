package cn.zxh.jdbc.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		Connection conn = DbUtils.getConnection();
		Statement statement = conn.createStatement();
		String sql = "select * from jdbctest";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			int i1 = resultSet.getInt("id");
			String str = resultSet.getString("name");
			System.out.println(i1 + str);
		} 
		resultSet.close();
		statement.close();
		conn.close();
	}

}
