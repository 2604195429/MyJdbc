package cn.zxh.jdbc.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import cn.zxh.jdbc.DBUtils;

/**
 * ������������
 * 
 * @author developer
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		String sql = "insert into log_01 (id,msg) values(?,?)";
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement prepar = conn.prepareStatement(sql);
			for (int i = 0; i < 100; i++) {
				// �滻����
				prepar.setInt(1, i);
				prepar.setString(2, "name"+i);
				// ��������ӻ�����
				prepar.addBatch();
				if ((i+1)%8==0) {
					int[] batch = prepar.executeBatch();
					System.out.println(Arrays.toString(batch));
//					prepar.clearBatch();û�б�Ҫд
				}
			}
			// ����ִ��
			int[] batch = prepar.executeBatch();
			System.out.println(Arrays.toString(batch));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}

	}

}
