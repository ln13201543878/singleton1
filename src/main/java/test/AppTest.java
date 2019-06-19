package test;

import static org.junit.Assert.*;

import org.junit.Test;
//单例模式 饱汉式    私有化静态对象 私有构造器 获取对象的方法
class Singleton{
	private static Singleton instance = new Singleton();
	private  Singleton() {
		
	}
	
	public static Singleton getSingleton() {
		return instance;
	}
	
	
}


public class AppTest {
	@Test
	public void testName() throws Exception {
		Singleton s = Singleton.getSingleton();
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
	}
}
