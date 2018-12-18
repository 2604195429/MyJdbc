package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import cn.zxh.jdbc.DBUtils;
import cn.zxh.jdbc.day01.DbUtils;

/**
 * SQL 注入演示
 * 
 * @author developer
 *
 */
public class Demo7 {

	public static void main(String[] args) {
		// 获取用户输入
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String password = scanner.nextLine();
		// 检查登录情况
		System.out.println(login1(name, password));
	}

	// 检查用户是否能登录
	public static boolean login(String name, String password) {
		String sql = "select count(*) as c from usertest where name='" + name + "' and password='" + password + "'";
		System.out.println(sql);
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				int n = resultSet.getInt("n");
				return n >= 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
			DbUtils.close(conn);
		}
		return false;
	}

	public static boolean login1(String name, String password) {
		String sql = "select count(*) as c from usertest where name=? and password=?";
		System.out.println(sql);
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int n = resultSet.getInt(1);
				return n >= 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally");
			DbUtils.close(conn);
		}
		return false;
	}
}
