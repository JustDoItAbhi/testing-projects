package inventory2.inventory2.inventory.dtos;

import inventory2.inventory2.inventory.models.UserType;
import lombok.Data;

@Data
public class UserREQUETdTO {
    private String name;
    private String email;
    private UserType userType;
}
