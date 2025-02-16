package inventory2.inventory2.inventory.dtos;

import inventory2.inventory2.inventory.models.User;
import inventory2.inventory2.inventory.models.UserType;
import lombok.Data;

@Data
public class UserReponseDto {
   private int id;
    private String name;
    private String email;
    private UserType userType;
    public static UserReponseDto from(User user){
        UserReponseDto reponseDto=new UserReponseDto();
        reponseDto.setId(user.getId());
        reponseDto.setName(user.getName());
        reponseDto.setEmail(user.getEmail());
        reponseDto.setUserType(user.getUserType());
       return reponseDto;
    }
}
