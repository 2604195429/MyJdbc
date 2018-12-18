package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 连接池的使用方法
 * @author developer
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		String driver  = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "system";
		String password = "zxh001019";
		BasicDataSource ds = new BasicDataSource();
		//设置必须的参数
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		ds.setInitialSize(10);
		ds.setMaxActive(20);
		ds.setMaxIdle(10);
		Connection connection = ds.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from jdbctest");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("name"));
		}
		//归还连接到数据库连接池
		connection.close();
	}
}
