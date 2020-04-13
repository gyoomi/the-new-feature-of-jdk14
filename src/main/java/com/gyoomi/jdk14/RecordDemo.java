/**
 * Copyright © 2020, Glodon Digital Supplier BU.
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.jdk14;

/**
 * Record的使用
 *
 * @author Leon
 * @date 2020-04-13 8:47
 */
public class RecordDemo
{
	public static void main(String[] args) {
		Student stu = new Student(1001, "张三");
		System.out.println(stu);
		System.out.println(stu.getClass());
		System.out.println(stu.id());
		System.out.println(stu.name());

		System.out.println("==============================");

		Person p = new Person(1000, "李四", 22);
		System.out.println(p);
		System.out.println(p.getClass());
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
}

record Student(Integer id, String name){}

class Person
{

	private Integer id;
	private String name;
	private Integer age;

	public Person(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}


