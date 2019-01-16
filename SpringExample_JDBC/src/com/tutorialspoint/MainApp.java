package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate jdbc = (StudentJDBCTemplate) cxt.getBean("studentJDBCTemplate");
		
		jdbc.create("Zara", 11);
		jdbc.create("B", 12);
		jdbc.create("A", 13);
		
		List<Student> sl = jdbc.listStudents();
		
		for (Student student : sl) {
			
			System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
		}
		
		jdbc.update(2, 15);
		
		Student s = jdbc.getStudent(2);
		
		System.out.println(s.getId() + " " + s.getName() + " " + s.getAge());
	}
}
