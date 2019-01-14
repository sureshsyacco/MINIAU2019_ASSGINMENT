package advanced_java_au_assignment;

import java.util.*;

class NameSort implements Comparator<Employee> 
{
    
    public int compare(Employee e1, Employee e2) 
    { 
        return e1.ename.compareTo(e2.ename); 
    } 
}