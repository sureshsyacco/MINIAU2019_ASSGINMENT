package com.factory.FactoryMethod;

public class StudentDto {
	 private Integer id;
	 private String name;
	    private String studentType;
	    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

		
	 
	    
	 
	    @Override
	    public String toString() {
	        return "Student [id=" + id + ",Name=" + name + ", type=" + studentType + "]";
	    }
}
