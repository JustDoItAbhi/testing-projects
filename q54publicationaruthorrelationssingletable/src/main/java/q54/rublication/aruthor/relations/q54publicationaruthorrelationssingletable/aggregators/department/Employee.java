package q54.rublication.aruthor.relations.q54publicationaruthorrelationssingletable.aggregators.products.department;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
private String name;
private double salary;
    public Employee( String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public Employee() {
    }
}
