package inventory.inventory.dtos;

import inventory.inventory.models.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class UserREQUETdTO {
    private String name;
    private String email;
    private UserType userType;
}
