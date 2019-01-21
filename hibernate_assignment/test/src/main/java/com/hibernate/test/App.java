package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.test.pojo.Course;
import com.hibernate.test.pojo.Student;

public class App {

	public static void main(String[] args) {
		// List <Course>courseList= new ArrayList<Course>();
		List<Student> studentList = new ArrayList<Student>();
		System.out.println("Hello");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
//		Student s=new Student();
//		 s.setStudentId(2);
//		 s.setStudentName("suresh2");
//		 s.setStudentAge(23);
//		 Integer id=(Integer)session.save(s);
//		 System.out.println(id);
		 

		/*Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.gt("studentAge", 21));
		 cr.add(Restrictions.gt("studentId", 50));
		studentList= cr.list();

		// cr.add(Restrictions.disjunction().add(Restrictions.eq("studentId",77)));
		// System.out.println(studentList.size());
		// for(Student e:studentList)
		// {
		// {
		// if(e.getStudentId()==77) {
		// System.out.println("name:"+e.getStudentName());
		// }
		// }

		// }

		*/
//		 Course c=new Course();
//		 c.setCourseId(1);
//		 c.setCourseName("Hibernate"); 
//		 c.setStudentId(1);
//		 System.out.println(session.save(c));
		 

		// courseid-217
		/*
		 * Criteria cr = session.createCriteria(Course.class); courseList= cr.list();
		 * for(Course s:courseList) { { if(s.getCourseId()==217) {
		 * System.out.println("name:"+s.getCourseName()); } }
		 * 
		 * }
		 */
		/*System.out.println("completed");
		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.eq("studentId", 77));
		studentList = cr.list();
		int i = 0;
		for (Student e : studentList) {
			{
				if (e.getStudentId() == 77) {
					System.out.println("name:" + e.getStudentName() +
							"List:" + e.getCourses().get(i).getCourseName());
				}
			}
			i++;
		}
		
		
		*/
		Criteria cr = session.createCriteria(Student.class);
//		cr.add(Restrictions.gt("studentAge", 21));
//		 cr.add(Restrictions.gt("studentId", 50));
		studentList= cr.list();
		for(Student student: studentList) {
			  System.out.println( student.getStudentName()+"|" 
			  +student.getStudentAge()+"|"
			  +student.getStudentId()+"|"
			  +(!student.getCourses().isEmpty()?student.getCourses().get(0).getCourseName()
			  :"") ); 
		
		

		session.getTransaction().commit();

	}

	}
}
