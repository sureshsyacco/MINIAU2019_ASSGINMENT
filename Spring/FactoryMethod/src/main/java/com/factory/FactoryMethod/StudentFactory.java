package com.factory.FactoryMethod;

public class StudentFactory {
	public static StudentDto createStudentOfType(String type)
    {
        if ("parttime".equals(type) || "fulltime".equals(type))
        {
            StudentDto student = new StudentDto();
             
            student.setId(-1);
            student.setName("dummy");
            
            //Set designation here
            student.setStudentType(type);
             
            return student;
        }
        else
        {
            throw new IllegalArgumentException("Unknown student type");
        }
    }

}
