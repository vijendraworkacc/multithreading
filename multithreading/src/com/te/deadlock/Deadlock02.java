package com.te.deadlock;

public class Deadlock02 {
	public static Object object01 = new Object();
	public static Object object02 = new Object();

	public static void main(String[] args) {
		Thread thread01 = new Thread(() -> {
			synchronized (object01) {
				System.out.println("Inside the sysnchronized block 1!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.getMessage();
				}
				synchronized (object02) {
					System.out.println("Inside the inner sysnchronized block!");
				}
				System.out.println("End of the sysnchronized block 1!");
			}
		});

		Thread thread02 = new Thread(() -> {
			synchronized (object02) {
				System.out.println("Inside the sysnchronized block 2!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.getMessage();
				}
				synchronized (object01) {
					System.out.println("Inside the inner sysnchronized block!");
				}
				System.out.println("End of the sysnchronized block 2!");
			}
		});
		
		thread01.start();
		thread02.start();
	}
}
