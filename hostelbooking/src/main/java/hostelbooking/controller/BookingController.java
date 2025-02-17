package hostelbooking.controller;

import hostelbooking.dtos.BookingRequestDto;
import hostelbooking.dtos.BookingResponseDto;
import hostelbooking.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    //Add APIs here
    @GetMapping("/guest/{guestEmail}")
    public ResponseEntity<List<BookingResponseDto>> getAllBooking(@PathVariable("guestEmail")String guestEmail){
        return ResponseEntity.ok(bookingService.getAllBookingsPerGuest(guestEmail));
    }
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDto> getBooking(@PathVariable("bookingId")Long bookingId){
        return ResponseEntity.ok(bookingService.getBooking(bookingId));
    }
    @PostMapping
    public ResponseEntity<BookingResponseDto> createBooking(@RequestBody BookingRequestDto dto){
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }
    @PutMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDto> updateBooking(@RequestBody BookingRequestDto dto){
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable ("bookingId")Long bookingId){
        return ResponseEntity.ok(bookingService.deleteBooking(bookingId));
    }


}

