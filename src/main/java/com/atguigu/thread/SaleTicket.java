package com.atguigu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
	private int number = 30;
	private Lock lock = new ReentrantLock();
	
	public void sale() {
		lock.lock();
		try {
			if(number > 0) {
				System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票,还剩下" + number + "张票");
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			lock.unlock();
		}
	}
	/*
	public synchronized void sale() {
		while (number > 0) {
			System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票,还剩下" + number + "张票");
		}
	}
	*/
}

/**
 * @Description:卖票程序复习线程知识 , 三个售票员 卖出 30张票
 * @author Lenovo
 * @date 2018年4月3日 
 * 笔记：Java里面如何进行工程级别的多线程编写 
 * 1 多线程变成模板（套路）-----上 
 * 1.1 线程 操作 资源类
 * 1.2 高内聚 低耦合
 */
public class SaleTicket {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(() -> { for (int i = 1; i <= 30; i++) ticket.sale(); },"窗口一").start();; 
		new Thread(() -> { for (int i = 1; i <= 30; i++) ticket.sale(); },"窗口二").start();; 
		new Thread(() -> { for (int i = 1; i <= 30; i++) ticket.sale(); },"窗口三").start();; 
		
		/*
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 30; i++) {
					ticket.sale();
				}
			}
		}, "窗口一").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 30; i++) {
					ticket.sale();
				}
			}
		}, "窗口二").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 30; i++) {
					ticket.sale();
				}
			}
		}, "窗口三").start();
		*/
	}
}

