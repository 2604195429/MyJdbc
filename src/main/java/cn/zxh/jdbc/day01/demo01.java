package cn.zxh.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import oracle.jdbc.proxy.annotation.GetCreator;

public class demo01 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("ok");
		// ���ӵ����ݿ�
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "zxh001019";
		// getConnection�������Ҳ��ҳ������ӵ����ݿ⣬������ɹ��������쳣
		Connection connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		// ���connection���ö����ʵ������
		// ֤�������������ṩ��connection�ӿڵ�ʵ����
		System.out.println(connection.getClass());
		// ��������䡯����
		Statement statement = connection.createStatement();
		// ִ��sql
		/*String ddl = "create table jdbctest(id number(7),name varchar(100))";
		boolean b = statement.execute(ddl);
		connection.commit();
		// ���ؽ����true ��ʾ�н���� falseû�н���� ����ʧ���׳��쳣�����û���쳣�򴴽��ɹ�
		System.out.println(b);*/
		statement.close();
		connection.close();
		
	}

}
