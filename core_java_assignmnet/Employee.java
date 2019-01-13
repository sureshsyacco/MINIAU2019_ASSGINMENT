package core_java_assignmnet;

public class Employee {
	private int eid,age,years_of_exp;//declaring all attributes as private for data encapuslation
	private String ename;
	
	//getters for getting values of private variables,bcoz outside class these variables
	//are not accessible
	public int get_employee_id()
	{
		return this.eid;
	}
	
	public int get_age()
	{
		return this.age;
	}
	
	public int get_experience()
	{
		return this.years_of_exp;
	}
	
	public String get_employee_name() {
		return this.ename;
	}
	
	//setters for setting values of private variables
	
	public void set_employee_id(int eid)
	{
		this.eid=eid;
	}
	
	public void set_age(int age)
	{
		this.age=age;
	}
	
	public void set_experience(int exp)
	{
		this.years_of_exp=exp;
	}
	
	public void set_employee_name(String name)
	{
		this.ename=name;
	}
	
	public  void Employee_details()
	{
		System.out.println("Name:"+this.get_employee_name()+" "+
	"age:"+this.get_age()+" "+"experience:"+this.get_experience());
	}
	
	
	
	
	
	

}

class HR extends Employee{
	private String previous_company;
	
	public String get_previous_company() {
		return this.previous_company;
	}
	
	public void set_previous_company(String company) {
		this.previous_company=company;
	}
	
	public void HR_details()
	{
		System.out.println("Name:"+this.get_employee_name()+" "+
	"age:"+this.get_age()+" "+"experience:"+this.get_experience()+" "+
	"previous company:"+this.get_previous_company());
	}
}


class Developer extends Employee{
	private int salary;
	private String coding_lang;
	
	public int get_salary() {
		return this.salary;
	}
	
	public String get_coding_lang() {
		return this.coding_lang;
	}
	
	public void set_coding_lang(String lang) {
		this.coding_lang=lang;
	}
	
	public void set_salary(int salary)
	{
		this.salary=salary;
	}
	
	public void Developer_details()
	{
		System.out.println("Name:"+this.get_employee_name()+" "+
	"age:"+this.get_age()+" "+"experience:"+this.get_experience()+" "+
	"salary:"+this.get_salary()+" "+"coding_lang:"+this.get_coding_lang());
	}
}

