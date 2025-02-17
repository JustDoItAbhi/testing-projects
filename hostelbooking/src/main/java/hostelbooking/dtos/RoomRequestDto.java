package hostelbooking.dtos;

import hostelbooking.models.RoomType;
import lombok.Data;

@Data
public class RoomRequestDto {
    RoomType roomType;
    int roomCount;
}
