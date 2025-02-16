package inventory.inventory.dtos;

import inventory.inventory.models.Inventory;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class CreateOrUpdateResponseDto {
    private Inventory inventory;
    @OneToMany
    private ResponseStatus responseStatus;
    public static CreateOrUpdateResponseDto from(Inventory inventory){
        CreateOrUpdateResponseDto responseDto=new CreateOrUpdateResponseDto();
        responseDto.setInventory(inventory);
        responseDto.setResponseStatus(responseDto.responseStatus);
        return responseDto;
    }
//    public static Inventory to(CreateOrUpdateRequestDto requestDto){
//        Inventory inventory1=new Inventory()
//    }

}
