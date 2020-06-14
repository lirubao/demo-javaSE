package com.java.proxy.jdk;

public class Client {
	public static void main(String[] args) {
		//通过接口
		Subject subject = new Proxy(new RealSubject());
		subject.test();
	}
}
