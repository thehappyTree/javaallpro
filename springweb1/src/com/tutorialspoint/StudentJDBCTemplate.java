package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO{
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.jdbcTemplateObject = new JdbcTemplate(ds);
		
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		// TODO Auto-generated method stub
		try {
		String SQL1 = "insert into Student(name, age) values(?,?)";
		this.jdbcTemplateObject.update(SQL1, name, age);
		String SQL2 = "select max(id) from student";
		int sId = this.jdbcTemplateObject.queryForObject(SQL2, Integer.class);
		String SQL3 = "insert into Marks(sid, marks, year) " + 
                "values (?, ?, ?)";
		this.jdbcTemplateObject.update(SQL3,sId,marks,year);
        System.out.println("Created Name = " + name + ", Age = " + age);
		//throw new RuntimeException("simulu exception");
		
		}catch(DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
		
	}

	@Override
	public List<StudentMarks> listStudents() {
		// TODO Auto-generated method stub
		String SQL = "select * from Student,Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
				new StudentMarksMapper());
		return studentMarks;
	}
	




}
