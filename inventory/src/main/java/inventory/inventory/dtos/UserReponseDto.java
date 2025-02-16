package inventory.inventory.dtos;

import inventory.inventory.models.User;
import inventory.inventory.models.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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
