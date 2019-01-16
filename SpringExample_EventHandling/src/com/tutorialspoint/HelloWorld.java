package com.tutorialspoint;

public class HelloWorld {

	private String msg;
	
	public void setMsg (String msg) {
		this.msg = msg;
	}
	public void getMsg () {
		System.out.println("Your message: " + msg);
	}
}
