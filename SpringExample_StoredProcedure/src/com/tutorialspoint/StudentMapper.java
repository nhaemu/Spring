package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student s = new Student();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setAge(rs.getInt("age"));
		return s;
	}

}
