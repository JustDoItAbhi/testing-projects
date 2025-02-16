package inventory2.inventory2.inventory.service;



import inventory2.inventory2.inventory.dtos.UserREQUETdTO;
import inventory2.inventory2.inventory.dtos.UserReponseDto;

import java.util.List;

public interface UserServices {
UserReponseDto createUser(UserREQUETdTO requeTdTO);
List<UserReponseDto> allUser();
}
