package inventory2.inventory2.inventory.service;

import inventory2.inventory2.inventory.dtos.UserREQUETdTO;
import inventory2.inventory2.inventory.dtos.UserReponseDto;
import inventory2.inventory2.inventory.models.User;
import inventory2.inventory2.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServices{
   @Autowired
   private UserRepository userRepository;
    @Override
    public UserReponseDto createUser(UserREQUETdTO requeTdTO) {
        User user=new User();
        user.setName(requeTdTO.getName());
        user.setEmail(requeTdTO.getEmail());
        user.setUserType(requeTdTO.getUserType());
            userRepository.save(user);
        return UserReponseDto.from(user);
    }

    @Override
    public List<UserReponseDto> allUser() {
        List<User>users=userRepository.findAll();
        List<UserReponseDto>userReponseDtos=new ArrayList<>();
        for(User user:users) {
            userReponseDtos.add(UserReponseDto.from(user));
        }
        return userReponseDtos;
    }
}
