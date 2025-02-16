package inventory.inventory.service;

import inventory.inventory.dtos.UserREQUETdTO;
import inventory.inventory.dtos.UserReponseDto;

import java.util.List;

public interface UserServices {
UserReponseDto createUser(UserREQUETdTO requeTdTO);
List<UserReponseDto> allUser();
}
