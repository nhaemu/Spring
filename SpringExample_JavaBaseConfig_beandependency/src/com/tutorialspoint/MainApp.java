package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		
		TextEditor te = cxt.getBean(TextEditor.class);
		te.spellCheck();
	}
}
