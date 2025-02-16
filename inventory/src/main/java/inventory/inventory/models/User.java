package inventory.inventory.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
@Entity
public class User extends Basemodel{
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
