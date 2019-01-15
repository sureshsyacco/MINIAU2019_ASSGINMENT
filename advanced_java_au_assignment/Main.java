package advanced_java_au_assignment;

import java.util.*;

public class Main {
		public static void main(String[] args) {
				int p=10;//10 companies
			
				Company c[]=new Company[p];
				
				for(int i=0;i<p;i++)
				{
					c[i]=new Company();
				}
				for (int i=0;i<p;i++)
				{
					c[i].setCity("city"+String.valueOf(i));
					c[i].setStreet("street"+String.valueOf(i));
					
					
					c[i].E=new LinkedList<>();
					int number_employees;
					for(int j=0;j<number_employees;;j++)
					{
						String name;
						int age;
						int id;
						int exp;
						name="employee"+String.valueOf(j);
						age=26+j;
						id=1234+j;
						exp=3+j;
					    c[i].E.add(new Employee(name,age,id,exp));
					}
				}
				
			for(int k=0;k<p;k++) {
		         //sort based on age
				Collections.sort(c[k].E,new SalaryCompare());
				for(Employee e:c[k].E){
		            System.out.println(e.toString());
				}
				 //sort based on names
		         Collections.sort(c[k].E, new NameSort());
		         for(Employee w:c[k].E){
			            System.out.println(w.toString());
		         }
		         //age<30
			            for(Employee b:c[k].E){
			            	if (b.age < 30)
			            	{
			            	
				            System.out.println(b.toString());
			            	}
			            }
			}
			

}
