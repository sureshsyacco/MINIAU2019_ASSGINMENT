package com.au.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.dao.StudentDao;
import com.au.spring.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public String getName()
	{
		return studentDao.getName();
	}
	
	public void insert(Student student)
	{
		studentDao.insert(student);
	}
	
	public List<Student> getAllStudents()
	{
		return studentDao.getAllStudents();
	}

}
