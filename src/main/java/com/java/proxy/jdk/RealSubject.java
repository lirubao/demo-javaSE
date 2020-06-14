package com.java.proxy.jdk;

// 目标类（实现上述接口）
public class RealSubject implements Subject {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("target method");
	}
}
