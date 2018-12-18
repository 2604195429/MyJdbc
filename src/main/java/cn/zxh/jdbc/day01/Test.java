package cn.zxh.jdbc.day01;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test implements Serializable {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public Test(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	// get/set·½·¨

	public static void main(String[] args)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Test person = new Test("luoxn28", 23);
		Class clazz = person.getClass();

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String key = field.getName();
			PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
			Method method = descriptor.getReadMethod();
			Object value = method.invoke(person);

			System.out.println(key + ":" + value);

		}
	}

}
