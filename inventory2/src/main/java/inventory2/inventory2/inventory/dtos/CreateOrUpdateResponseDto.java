package inventory2.inventory2.inventory.dtos;

import inventory2.inventory2.inventory.models.Inventory;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
public class CreateOrUpdateResponseDto {
    private Inventory inventory;
    private ResponseStatus responseStatus;
}
