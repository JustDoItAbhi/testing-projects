package inventory2.inventory2.inventory.dtos;

import lombok.Data;

@Data
public class CreateOrUpdateRequestDto {
    private int userId;
    private int productId;
    private int quantity;
}
