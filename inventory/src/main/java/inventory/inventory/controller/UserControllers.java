package inventory.inventory.controller;

import inventory.inventory.dtos.UserREQUETdTO;
import inventory.inventory.dtos.UserReponseDto;
import inventory.inventory.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {
    @Autowired
    private UserServices userServices;
    @PostMapping("/")
    public ResponseEntity<UserReponseDto> create(@RequestBody UserREQUETdTO requeTdTO){
        return  ResponseEntity.ok(userServices.createUser(requeTdTO));
    }
    @GetMapping("/")
    public ResponseEntity<List<UserReponseDto>> getAAll(){
        return ResponseEntity.ok(userServices.allUser());
    }
}
