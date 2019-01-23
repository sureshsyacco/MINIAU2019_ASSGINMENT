package com.au.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.au.spring.model.Student;

@Repository
public class StudentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getName() {
		return jdbcTemplate.queryForObject("select studentName from student limit 1", String.class);
	}

	public void insert(Student student) {

		String query = "insert into student(studentId,StudentName,studentAge) values " + "(" + student.getStudentId()
				+ ",\"" + student.getStudentName() + "\"," + student.getStudentAge() + ");";

		jdbcTemplate.update(query);

	}

	public List<Student> getAllStudents() {
		return jdbcTemplate.query("select * from student limit 5", new RowMapper<Student>() {
			// @Override
			public Student mapRow(ResultSet rs, int rownumber) throws SQLException {

				Student e = new Student();
				e.setStudentId(rs.getInt(1));
				e.setStudentName(rs.getString(2));
				e.setStudentAge(rs.getInt(3));
				return e;

			}
		});
	}

}
