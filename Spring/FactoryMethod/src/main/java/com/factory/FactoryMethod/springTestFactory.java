package com.factory.FactoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTestFactory {
	
	//@SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
        StudentDto parttime= (StudentDto) context.getBean("parttime");
        System.out.println(parttime);
         
        StudentDto fulltime = (StudentDto) context.getBean("fulltime");
        System.out.println(fulltime);
    }

}
