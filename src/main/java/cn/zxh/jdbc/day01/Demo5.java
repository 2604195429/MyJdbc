package cn.zxh.jdbc.day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// properties ��Ŀ�ľ���Ϊ�˶�ȡproperties�ļ���Ƶ�api����ײ�����ļ�io
		// properties ����ʵ����map�ӿ�
		Properties properties = new Properties();
		System.out.println(properties);
		System.out.println(properties.size());
		System.out.println(properties.isEmpty());

		InputStream in = Demo2.class.getClassLoader().getResourceAsStream("db.properties");
		properties.load(in);
		System.out.println(properties);
		System.out.println(properties.size());
	}
}
