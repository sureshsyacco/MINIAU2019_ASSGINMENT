package com.junit;

public class Marks {

	private int studentId;
	private int total;
	private Subject subject;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String[] getCSV() {
		return new String[] { String.valueOf(studentId), subject.toString(), String.valueOf(total ) };
	}

	@Override
	public boolean equals(Object obj) {
		Marks m = (Marks) obj;
		return (m.getStudentId()==this.studentId) && m.getTotal()==(this.total)
				&& m.getSubject().equals(this.subject);
	}
	
	
	
	
	public Marks(int studentId, Subject subject, int total) {
		super();
		this.studentId = studentId;
		this.subject = subject;
		this.total = total;
	}
	
	
	
	
	
}
