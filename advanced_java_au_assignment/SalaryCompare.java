package advanced_java_au_assignment;

import java.util.*;

public class SalaryCompare implements Comparator<Employee>{
	@Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getAge() > e2.getAge()){
            return 1;
        } else {
            return -1;
        }
    }

}
