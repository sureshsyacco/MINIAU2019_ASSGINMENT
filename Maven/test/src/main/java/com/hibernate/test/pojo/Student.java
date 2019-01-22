package com.hibernate.test.pojo;
//

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	

	@Id
	@Column(name="studentId")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer studentId;

	@Column(name="studentName")
	public String studentName;

	@Column(name="studentAge")
	public Integer studentAge;

	
	  public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
	this.courses = courses;
	}

@OneToMany(mappedBy="studentId", fetch=FetchType.EAGER) public List<Course>
  courses;
	 
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	//cant do selfjoin using hibernate
	//hibernates dont allow more than one list or bags so create sets

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}
	
	
	
	
	
}
