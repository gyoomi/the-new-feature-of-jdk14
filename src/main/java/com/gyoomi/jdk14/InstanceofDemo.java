/**
 * Copyright © 2020, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.jdk14;

/**
 * JDK14中instanceof 最新用法
 *
 * @author Leon
 * @date 2020-03-27 9:52
 */
public class InstanceofDemo
{
	public static void main(String[] args) {
		Object obj = "hello java";
//		Object obj = 2345;
		instanceTest(obj);
	}

	public static void instanceTest(Object obj)
	{
		if (obj instanceof String s)
		{
			System.out.println(String.format("字符串：%s", s));
		}
		else if (obj instanceof Integer i)
		{
			System.out.println(String.format("整数：%s", i));
		}
		else {
			throw new RuntimeException("obj的类型无法处理。");
		}
	}
}
