package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.department;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Employee employee=new Employee("rahul",100.000);
        Employee employee1=new Employee("raj",200.000);
        Employee employee2=new Employee("raju",300.000);
        Employee employee3=new Employee("raja",400.000);
        List<Employee>employeeList=new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        Department department=new Department();
        System.out.println(department.getHighestSalaryEmployee(employeeList));
    }
}
