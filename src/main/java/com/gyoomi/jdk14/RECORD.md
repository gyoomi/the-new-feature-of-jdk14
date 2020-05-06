# Record类型

## 1、概念

记录类型（`record`）是`JDK 14`的另一个预览功能。记录类型的作用类似于`Kotlin`中的数据类（`data class`)和`Scala`中的`case class`。记录类型的作用是作为不可变数据的封装。类似于**枚举类型**，记录类型是一种形式受限的类。一个记录类型由名称和状态描述两部分组成。状态描述声明了记录中包含的组件。

## 2、 示例

下面代码中的`Student`就是一个记录类型。记录类型使用record声明。`Student`记录类型的状态描述由`id`和`name`两个Integer、String类型的组件组成。可以通过`id()`和`name()`方法来访问。

```java
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
```

## 3、 深入理解

记录类型有自动生成的成员有以下几种：

- 状态描述中的每个组件都有对应的private final字段。
- 状态描述中的每个组件都有对应的public访问方法。方法的名称与组件名称相同。
- 一个包含全部组件的公开构造器，用来初始化对应组件。
- 实现了equals()和hashCode()方法。equals()要求全部组件都必须相等。
- 实现了toString()，输出全部组件的信息。


通过编译软件，查看Student的文件的内容如下：

```java
final class Student extends java.lang.Record {
    private final java.lang.Integer id;
    private final java.lang.String name;

    public Student(java.lang.Integer id, java.lang.String name) { /* compiled code */ }

    public java.lang.String toString() { /* compiled code */ }

    public final int hashCode() { /* compiled code */ }

    public final boolean equals(java.lang.Object o) { /* compiled code */ }

    public java.lang.Integer id() { /* compiled code */ }

    public java.lang.String name() { /* compiled code */ }
}
```

从中我们可以得到如下一些关键信息。

- 记录类型不能继承自其它类
- 记录类型不能有其他实例字段
- 记录类型都是final的，也不能是abstract的
- 记录中的字段也都是final的

如果需要在记录类型的构造器中添加校验或规格化的逻辑，可以定义自己的构造器。

>注意
>
>如果构造器不带形式参数（类似下面代码中的方式），则认为是要覆写默认生成的带全部组件的构造器（即覆写Student(Integer id, String name)）。

```java
record Student(Integer id, String name)
{
	public Student 
	{
		this.id = Math.abs(id);
		this.name = name.strip();
	}
}
```
































