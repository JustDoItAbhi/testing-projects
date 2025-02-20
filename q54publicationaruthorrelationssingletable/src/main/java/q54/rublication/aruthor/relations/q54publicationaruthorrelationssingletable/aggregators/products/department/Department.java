package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.department;

import lombok.Data;

import java.util.List;
@Data
public class Department {
    List<Employee> employeeList;

public Employee getHighestSalaryEmployee(List<Employee>employeeList){
    if (employeeList == null || employeeList.isEmpty()) {
        return null;  // Handle empty list case
    }

    Employee highestPaidEmployee = employeeList.get(0);
    for (Employee employee : employeeList) {
        if (employee.getSalary() > highestPaidEmployee.getSalary()) {
            highestPaidEmployee = employee;
        }
    }
    return highestPaidEmployee;
}
}
