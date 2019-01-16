package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource dataSource);
	public void create(String name, Integer age);
	public Student getStudent(Integer id);
	public List<Student> listStudents();
	public void update(String name, Integer id);
}
