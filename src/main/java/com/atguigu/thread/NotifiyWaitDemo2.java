package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintData{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void printNumber() {
		lock.lock();
		try {
			for (int i = 1; i <= 52; i++) {
				System.out.print(i);
				if(i%2 == 0) {
					condition.signalAll();
					condition.await();
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printAlphabet() {
		lock.lock();
		try {
			for (int i = 0; i < 26; i++) {
				System.out.print((char)(65+i));
				condition.signalAll();
				if(i != 25) {
					condition.await();
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

/**
 * @Description 写两个线程，一个线程打印1~52,一个线程打印A~Z，打印顺序为12A34B....5152Z
 * @author Lenovo
 * @date 2018年4月3日
 */
public class NotifiyWaitDemo2 {

	public static void main(String[] args) throws InterruptedException {
		PrintData printData = new PrintData();
		new Thread(() -> {
				printData.printNumber();
		}, "A").start();
		Thread.sleep(100);
		new Thread(() -> {
				printData.printAlphabet();
		}, "B").start();
	}

}
