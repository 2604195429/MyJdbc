package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.zxh.jdbc.DBUtils;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Demothread(5000);
		Thread t2 = new Demothread(6000);
		Thread t3 = new Demothread(1000);
		t1.start();
		t2.start();
		t3.start();
	}

}

class Demothread extends Thread {
	int wait;

	public Demothread(int wait) {
		this.wait = wait;
	}

	@Override
	public void run() {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			System.out.println("获取了连接" + conn);
			Thread.sleep(wait);
			String sql = "select * from jdbctest";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("id") + rs.getString("name"));
			}
			statement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			System.out.println(wait+"关闭");
		}
	}
}
