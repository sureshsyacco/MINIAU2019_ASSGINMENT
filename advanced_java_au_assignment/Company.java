package advanced_java_au_assignment;

import java.util.*;
public class Company {
	private String cname;
	List<Employee> employeeList;
	Address address=new Address();
	
	public void setCompanyName(String cname)
	{
		this.cname=cname;
	}
	
	public String getCompanyName()
	{
		return this.cname;
	}
	
	

}
