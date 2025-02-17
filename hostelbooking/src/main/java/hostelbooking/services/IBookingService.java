package hostelbooking.services;

import hostelbooking.dtos.BookingRequestDto;
import hostelbooking.dtos.BookingResponseDto;

import java.util.List;

public interface IBookingService {
    BookingResponseDto getBooking(Long bookingId);

    List<BookingResponseDto> getAllBookingsPerGuest(String guestEmail);

    BookingResponseDto replaceBooking(Long bookingId, BookingRequestDto bookingRequestDto);

    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);

    Boolean deleteBooking(Long bookingId);
}
