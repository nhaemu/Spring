package com.tutorialspoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO{

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCallRecord;
	private SimpleJdbcCall jdbcSetRecord;
	private SimpleJdbcCall jdbcUpdRecord;
	
	@Override
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
		this.jdbcCallRecord = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
		this.jdbcSetRecord = new SimpleJdbcCall(dataSource).withProcedureName("setRecord");
		this.jdbcUpdRecord = new SimpleJdbcCall(dataSource).withProcedureName("updRecord");
	}

	@Override
	public void create(String name, Integer age) {
		Map<String,Object> values = new HashMap(); 
		values.put("in_name", name);
		values.put("in_age", age);
		SqlParameterSource in = new MapSqlParameterSource().addValues(values);
		jdbcSetRecord.execute(in);
	}

	@Override
	public Student getStudent(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
		Map<String, Object> out = jdbcCallRecord.execute(in);
		
		Student s = new Student();
		s.setId(id);
		s.setName((String) out.get("out_name"));
		s.setAge((Integer) out.get("out_age"));
		return s;
	}

	@Override
	public List<Student> listStudents() {
		JdbcTemplate obj = new JdbcTemplate(dataSource);
		String sql = "select * from Student";
		List<Student> sl = obj.query(sql, new StudentMapper());
		return sl;
	}

	@Override
	public void update(String name, Integer id) {
		Map<String,Object> values = new HashMap(); 
		values.put("in_name", name);
		values.put("in_id", id);
		SqlParameterSource in = new MapSqlParameterSource().addValues(values);
		jdbcUpdRecord.execute(in);
	}
}
