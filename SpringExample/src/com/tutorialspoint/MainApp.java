package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanPrototype.xml");
		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
		obj1.setMessage("I am object A");
		obj1.getMessage();
		
		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
		obj2.getMessage();
	}
}
