package cn.zxh.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ÷¥––dml”Ôæ‰
 * @author developer
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "zxh001019";
		Connection connection = DriverManager.getConnection(url, user, password);
		
		Statement statement = connection.createStatement();
//		String sql = "insert into jdbctest values(1,'zhang')";
		String sql = "update jdbctest  set name = 'xin' where id = 1";
		int n = statement.executeUpdate(sql);
		System.out.println(n);
		statement.close();
		connection.close();
	}
}
