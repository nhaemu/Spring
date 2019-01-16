package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Student s = (Student) context.getBean("student");
		System.out.println("Name: " + s.getName());
		System.out.println("Age: " + s.getAge());
	}
}
