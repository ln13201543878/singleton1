package test;

import static org.junit.Assert.*;

import org.junit.Test;
//singleton 懒汉模式 与线程安全

class Singleton1 {
	private static Singleton1 instance = null;

	private Singleton1() {
	}

	public static Singleton1 getSingleton() {
		if (instance == null) {
			synchronized (Singleton1.class) {
				if (instance == null) {
					instance = new Singleton1();
				}

			}
		}
		return instance;
	}
}

class T implements Runnable {

	@Override
	public void run() {
		Singleton1 s = Singleton1.getSingleton();
		System.out.println(Thread.currentThread() + "" + s);
	}

}

public class AppTest1 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			T tt = new T();
			Thread t = new Thread(tt);
			t.start();
		}
	}
}
