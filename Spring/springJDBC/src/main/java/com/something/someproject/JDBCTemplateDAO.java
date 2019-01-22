package com.something.someproject;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;  

@Component
public class JDBCTemplateDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<Student> getAllStudents(){  
		return jdbcTemplate.query("select * from student limit 5",new ResultSetExtractor<List<Student>>(){  
		    //@Override  
		     public List<Student> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		    	List<Student> list=new ArrayList<Student>();  
		        while(rs.next()){  
		        Student e=new Student();  
		        e.setStudentId(rs.getInt(1));  
		        e.setStudentName(rs.getString(2));  
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  ;
		    });  
	}
	
	
	
	
	
	public List<Student> getAllStudentsRowMapper(){  
		return jdbcTemplate.query("select * from student limit 5",new RowMapper<Student>(){  
		    //@Override  
			public Student mapRow(ResultSet rs, int rownumber) throws SQLException {  
		      
				 Student e=new Student();  
				 e.setStudentId(rs.getInt(1));  
			        e.setStudentName(rs.getString(2)); 
			        return e;  
		         
		        }  ;
		    });  
	}
	
	
	

	public int saveStudent(Student student){
		String query = "insert into student(student_id,sname) values "
				+ "('"+student.getStudentId()+"','"+student.getStudentName()+"')";
		return jdbcTemplate.update(query);
	}
}
