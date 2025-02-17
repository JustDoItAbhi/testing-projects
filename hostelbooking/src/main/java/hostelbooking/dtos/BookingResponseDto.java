package hostelbooking.dtos;

import hostelbooking.models.Guests;
import hostelbooking.models.Room;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookingResponseDto {
    private Long bookingId;

    private Double totalBill;

    private Guests guest;

    private List<Room> rooms;

    private Date checkInDate;

    private Date checkOutDate;
}
