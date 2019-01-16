package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	@Override
	public void setDataSource(DataSource ds) {

		this.dataSource = ds;
		this.jdbcTemplateObj = new JdbcTemplate(ds);
	}

	@Override
	public void create(String name, Integer age) {

		String SQL = "insert into Student(name,age) values(?,?)";
		jdbcTemplateObj.update(SQL, name, age);
		
		System.out.println(name + " " + age + " created.");
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		String sql = "select * from Student where id = ?";
		Student s = jdbcTemplateObj.queryForObject(sql, new Object[]{id}, new StudentMapper());
		return s;
	}

	@Override
	public List<Student> listStudents() {
		String sql = "select * from Student";
		List<Student> sl = jdbcTemplateObj.query(sql, new StudentMapper());
		return sl;
	}

	@Override
	public void delete(Integer id) {

		String sql = "delete from Student where id = ?";
		jdbcTemplateObj.update(sql, id);
		
		System.out.println(id + " record is delected.");
	}

	@Override
	public void update(Integer id, Integer age) {

		String sql = "update Student set age = ? where id = ?";
		jdbcTemplateObj.update(sql, age, id);
		
		System.out.println(id + " is updated to age " + age);
	}

}
