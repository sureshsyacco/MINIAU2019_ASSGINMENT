package com.soapassignment;
import java.util.Set;

import com.soapassignment.Person;

import com.soapassignment.Person_implementation;


public class Person_Interface{
	Person_implementation p=new Person_implementation();
	public String addPerson(String name,int id,int age)
	{
		return p.create(age, name, id);
	}
	
	
	
	public String deletePerson(int id)
	{
		return p.delete(id);
	}
	
	public String updatePerson(int id,String name,int age)
	{
		return p.update(name,id,age);
	}
	
	public String getPersons(int k)
	{
		return p.getPersons(k);
	}
}
