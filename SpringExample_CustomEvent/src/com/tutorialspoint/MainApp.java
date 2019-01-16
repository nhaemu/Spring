package com.tutorialspoint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt = new ClassPathXmlApplicationContext("Beans.xml");
		
		EventClassPublisher phr = (EventClassPublisher)cxt.getBean("eClassPublisher");
		
		phr.publish();
		
	}
}
