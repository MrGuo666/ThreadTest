package com.atguigu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Book {
	private Integer id;
	private String name;
	private double price;
	
//	private @Getter Integer id;
//	private @Getter@Setter String name;
//	private @Setter double price;
	//private String author;
	
	//1 新建Maven工程
	
	//2 导入lombok的配置连接
	
	//3 指定eclipse的安装路径告诉lombok，让eclipse可以识别
	
	//4 lombok的注解编程
}
