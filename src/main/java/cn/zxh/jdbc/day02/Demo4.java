package cn.zxh.jdbc.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.zxh.jdbc.DBUtils;

/**
 * ��ʾԤ�����sqlִ�мƻ�
 * 
 * @author developer
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into jdbctest (id,name) values (?,?)";
			//����ֵ����ִ�мƻ�
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ps.setString(2, "jusly");
			int i = ps.executeUpdate();
			System.out.println(i);
			
			ps.setInt(1, 3);
			ps.setString(2, "july");
			int n = ps.executeUpdate();
			System.out.println(n);
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}

}
