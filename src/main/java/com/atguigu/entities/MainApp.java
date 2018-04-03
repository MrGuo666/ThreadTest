package com.atguigu.entities;

public class MainApp {

	public static void main(String[] args) {
		Book book = new Book(1, "mysql", 33.5d);
		System.out.println(book.toString());
		book = new Book();
		book.setId(11);
		book.setName("java");
		book.setPrice(33.4d);
		
		new Book().setId(13).setName("nginx").setPrice(14.5d).toString();
	}

}
