package com.something.someproject;

  
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Fruit f = (Fruit)applicationContext.getBean("Fruit");
//		System.out.println(f.getApple().getColor());
		
		JDBCTemplateDAO jdbc = (JDBCTemplateDAO) applicationContext.getBean("JDBCTemplateDAO");
		/*Student student = new Student();
		student.setStudentId(3);
		student.setStudentName("accolite");
		j.saveStudent(student);*/
		
		System.out.println("Extracting 5 students using ResultExtractor");
		
		List<Student> list=jdbc.getAllStudents();  
		
		for(Student e:list)  {
	        System.out.println("id:"+e.getStudentId()+"  name:"+e.getStudentName());  
	          
	    }  
		
		System.out.println("Extracting 5 students using RowMapper");
		
		List<Student> list1=jdbc.getAllStudentsRowMapper();  
		
		for(Student e:list1)  {
	        System.out.println("id:"+e.getStudentId()+"  name:"+e.getStudentName());  
	          
	    }  
	}
}
