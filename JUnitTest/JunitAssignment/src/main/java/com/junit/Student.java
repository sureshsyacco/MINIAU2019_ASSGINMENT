package com.junit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {
	

		private int studentId;
		private String studentName;
		private int studentAge;
		
		private Map<Subject, Marks> studentMarks = new HashMap<Subject, Marks>();
		
		public Student(int studentId, String studentName, int studentAge) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentAge = studentAge;
		}
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public int getStudentAge() {
			return studentAge;
		}
		public void setStudentDob(int studentAge) {
			this.studentAge = studentAge;
		}
		
		
		
		public String[] getCSV() {
			return new String[] { String.valueOf(studentId), studentName, String.valueOf(studentAge) };
		}

		@Override
		public boolean equals(Object obj) {
			Student s = (Student) obj;
			return (s.getStudentId()==(this.studentId) && s.getStudentName().equals(this.studentName)
					&& s.getStudentAge()==(this.studentAge));
		}
		
		
		public Map<Subject, Marks> getStudentMarks() {
			return studentMarks;
		}
		
		
		@Override
		public String toString() {
			return "{" + studentId + "::" + studentName + "::" + studentAge+"}";
		}
	}

