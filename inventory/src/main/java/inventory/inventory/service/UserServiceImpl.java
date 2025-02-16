package inventory.inventory.service;

import inventory.inventory.dtos.UserREQUETdTO;
import inventory.inventory.dtos.UserReponseDto;
import inventory.inventory.models.User;
import inventory.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServices{
   @Autowired
   private UserRepository repository;
    @Override
    public UserReponseDto createUser(UserREQUETdTO requeTdTO) {
        User user=new User();
        user.setName(requeTdTO.getName());
        user.setEmail(requeTdTO.getEmail());
        user.setUserType(requeTdTO.getUserType());
            repository.save(user);
        return UserReponseDto.from(user);
    }

    @Override
    public List<UserReponseDto> allUser() {
        List<User>users=repository.findAll();
        List<UserReponseDto>userReponseDtos=new ArrayList<>();
        for(User user:users) {
            userReponseDtos.add(UserReponseDto.from(user));
        }
        return userReponseDtos;
    }
}
