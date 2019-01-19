package com.soapassignment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.soapassignment.Person;

public class Person_implementation{
	static HashMap<Integer, Person> persons = new HashMap<>();
		
		public Person_implementation() {
			persons.put(1, new Person("foo", 25, 1));
			persons.put(2, new Person("bar", 47, 2));
			persons.put(3, new Person("alex", 32, 3));
		}
		
//		show all
		public Set<Person> get(){
			Set<Person> personSet = new HashSet<Person>();
			personSet.addAll(persons.values());
			return personSet;
		}
		
//		show 1
		public Person get(int eid){
			return persons.get(eid);
		}
		
//		create
		public String create(int age,String name,int id) {
			persons.put(id,new Person(name,age,id));
			return "created";
		}
		
//		delete
		public String delete(int eid) {
			persons.remove(eid);
			return "Deleted";
		}
		
//		update
		public String update(String name,int id,int age) {
			Person personToUpdate = persons.get(id);
			personToUpdate.setAge(age);
			personToUpdate.setName(name);
			return "updated";
		}
		
		//to get all persons
		public  String getPersons(int k) {
			String s="suresh";
			Iterator<Map.Entry<Integer, Person>> itr = persons.entrySet().iterator();
			
			
			while(itr.hasNext())
			{
				Map.Entry<Integer, Person> entry = itr.next();
				s += entry.getValue(); 
			}
			return s;
		}
	}



