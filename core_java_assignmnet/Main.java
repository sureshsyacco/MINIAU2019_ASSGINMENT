package core_java_assignmnet;

//coding first time in JAVA,so writting simple code

public class Main {
	
	static { 
	    System.out.println("Program Demonstrates inheritence and data encapsulation "); 
	} 
	public static void main(String[] args) {
		Employee e1=new Employee();
		e1.set_employee_name("suresh");
		e1.set_age(22);
		e1.set_employee_id(1);
		e1.set_experience(4);
		e1.Employee_details();
		
		
		HR h1=new HR();
		h1.set_employee_name("sundar");
		h1.set_age(82);
		h1.set_employee_id(8);
		h1.set_experience(4);
		h1.set_previous_company("accenture");
		h1.HR_details();
		
		
		Developer d1=new Developer();
		d1.set_employee_name("rajesh");
		d1.set_age(42);
		d1.set_employee_id(10);
		d1.set_experience(20);
		d1.set_salary(200000);
		d1.set_coding_lang("JAVA");
		d1.Developer_details();
		
	}

}
