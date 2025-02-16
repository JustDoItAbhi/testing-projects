package inventory2.inventory2.inventory.controller;

import inventory2.inventory2.inventory.dtos.UserREQUETdTO;
import inventory2.inventory2.inventory.dtos.UserReponseDto;
import inventory2.inventory2.inventory.exceptions.UserNotFoundException;
import inventory2.inventory2.inventory.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {
    @Autowired
    private UserServices userServices;
    @PostMapping("/create")
    public ResponseEntity<UserReponseDto> create(@RequestBody UserREQUETdTO requeTdTO) throws UserNotFoundException {
        if(requeTdTO.getName().equals(null)){
            throw new UserNotFoundException("USER NOT FOUND IN CONTROLER");
        }
        return  ResponseEntity.ok(userServices.createUser(requeTdTO));
    }
    @GetMapping("/")
    public ResponseEntity<List<UserReponseDto>> getAAll(){
        return ResponseEntity.ok(userServices.allUser());
    }
}
