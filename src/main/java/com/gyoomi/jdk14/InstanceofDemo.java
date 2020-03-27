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
		if (obj instanceof String s)
		{
			System.out.println(s);
		}
		else
		{
			System.out.println("obj不是字符串！！");
		}
	}
}
