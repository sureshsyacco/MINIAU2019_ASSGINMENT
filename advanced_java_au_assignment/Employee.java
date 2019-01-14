package advanced_java_au_assignment;

public class Employee {
	
	private int eid,age,years_of_exp;//declaring all attributes as private for data encapuslation
	String ename;
	
	//getters for getting values of private variables,bcoz outside class these variables
	//are not accessible
	public int getEmployeeId()
	{
		return this.eid;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public int getExperience()
	{
		return this.years_of_exp;
	}
	
	public String getEmployeeName() {
		return this.ename;
	}
	
	//setters for setting values of private variables
	
	public Employee(String name,int age, int id,int exp)
	{
		this.ename=name;
		this.age=age;
		this.eid=id;
		this.years_of_exp=exp;
	}
	
	public  void EmployeeDetails()
	{
		System.out.println("Name:"+this.getEmployeeName()+" "+
	"age:"+this.getAge()+" "+"experience:"+this.getExperience());
	}

}
