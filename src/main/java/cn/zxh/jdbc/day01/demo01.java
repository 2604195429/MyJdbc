package cn.zxh.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.proxy.annotation.GetCreator;

public class demo01 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("ok");
		// 链接到数据库
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "zxh001019";
		// getConnection方法查找并且尝试链接到数据库，如果不成功将出现异常
		Connection connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		// 输出connection引用对象的实际类型
		// 证明：驱动程序提供了connection接口的实现类
		System.out.println(connection.getClass());
		// 创建‘语句’对象
		Statement statement = connection.createStatement();
		// 执行sql
		/*String ddl = "create table jdbctest(id number(7),name varchar(100))";
		boolean b = statement.execute(ddl);
		connection.commit();
		// 返回结果：true 表示有结果集 false没有结果集 创建失败抛出异常，如果没有异常则创建成功
		System.out.println(b);*/
		statement.close();
		connection.close();
		
	}

}
