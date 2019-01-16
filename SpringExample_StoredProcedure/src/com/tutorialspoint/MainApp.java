package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate t = (StudentJDBCTemplate) cxt.getBean("template");
		
//		t.create("AA", 14);
//		t.create("bb", 15);
		
		List<Student> ls = t.listStudents();
		
		for (Student student : ls) {
			System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
		}

		Student student = t.getStudent(5);
		System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
		
		t.update("cc", 6);
		t.update("dd", 7);
		List<Student> lss = t.listStudents();
		
		for (Student student2 : lss) {
			System.out.println(student2.getId() + " " + student2.getName() + " " + student2.getAge());
		}
	}
}
