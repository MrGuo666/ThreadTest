package com.atguigu.thread;

//@FunctionalInterface
interface Foo{
	//public void sayHello();
	//public void say886();
	
	public int add(int x,int y);
	
	default int div(int x,int y) {
		return x/y;
	}
	
	public static int sub(int x,int y) {
		return x-y;
	}
}

/**
 * @deprecated Lambda Express-----> 函数式编程
 * @author Lenovo
 * @date 2018年4月3日
 * 1	(形参列表) -> {方法实现}
 * 2	@FunctionalInterface
 * 3	default方法默认实现
 * 4	静态方法实现
 */

public class LambdaDemo {

	public static void main(String[] args) {
//		Foo foo = new Foo() {
//			@Override
//			public void sayHello() {
//				System.out.println("Hello1108");
//			}
//
//			@Override
//			public void say886() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		foo.sayHello();
//		Foo foo = () -> { System.out.println("Hello1108 lambda v2"); };
//		foo.sayHello();
		Foo foo = (x,y) -> {
			System.out.println("come in add");
			return x+y;
		};
		System.out.println("result: "+foo.add(3, 2));
		System.out.println("result: "+foo.div(10, 5));
		System.out.println("result: "+Foo.sub(9, 5));
	}

}
