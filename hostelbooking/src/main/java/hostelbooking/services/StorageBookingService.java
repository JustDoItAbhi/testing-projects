package hostelbooking.services;

import hostelbooking.dtos.BookingRequestDto;
import hostelbooking.dtos.BookingResponseDto;
import hostelbooking.dtos.RoomRequestDto;
import hostelbooking.models.Booking;
import hostelbooking.models.Guests;
import hostelbooking.models.Room;
import hostelbooking.models.RoomType;
import hostelbooking.repositories.BookingRepo;
import hostelbooking.repositories.GuestRepo;
import hostelbooking.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class StorageBookingService implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private GuestRepo guestRepo;

    @Autowired
    private RoomRepo roomRepo;


    @Override
    public BookingResponseDto getBooking(Long bookingId) {
        Optional<Booking> savedBookings=bookingRepo.findById(bookingId);
        if(savedBookings.isEmpty()){
            return null;
        }
        return from(savedBookings.get());
    }

    @Override
    public List<BookingResponseDto> getAllBookingsPerGuest(String guestEmail) {
        Optional<Guests>savedGuest=guestRepo.findByEmail(guestEmail);
        if(savedGuest.isEmpty()){
            return null;
        }
        Guests guests=savedGuest.get();
        List<Booking> bookings=bookingRepo.findBookingsByGuest(guests);
        if(bookings.isEmpty()){
            return null;
        }
        List<BookingResponseDto>listOfBookings=new ArrayList<>();
        for(Booking booking:bookings){
            listOfBookings.add(from(booking));
        }
        return listOfBookings;
    }

    @Override
    public BookingResponseDto replaceBooking(Long bookingId, BookingRequestDto bookingRequestDto) {
        Optional<Booking>savedBooking=bookingRepo.findById(bookingId);
        if(savedBooking.isPresent()){
            bookingRepo.deleteById(bookingId);
        }
        Booking booking =new Booking();
        booking.setCheckInDate(null);
        return null;
    }



    @Override
    public Boolean deleteBooking(Long bookingId) {
       Optional<Booking>booking=bookingRepo.findById(bookingId);
       if(booking.isEmpty()){
           return false;
       }
        bookingRepo.deleteById(bookingId);
        return true;
    }

    private BookingResponseDto from(Booking booking) {
        BookingResponseDto responseDto = new BookingResponseDto();
        responseDto.setBookingId(booking.getId());
        responseDto.setRooms(booking.getRooms());
        responseDto.setGuest(booking.getGuest());
        responseDto.setTotalBill(booking.getTotalBill());
        responseDto.setCheckOutDate(booking.getCheckOutDate());
        responseDto.setCheckInDate(booking.getCheckInDate());
        return responseDto;
    }

    private Room from(RoomRequestDto roomRequestDto) {
        Room room = new Room();
        room.setRoomType(roomRequestDto.getRoomType());
        if(roomRequestDto.getRoomType().equals(RoomType.DELUXE)) {
            room.setRent(1000D * roomRequestDto.getRoomCount());
        }else if(roomRequestDto.getRoomType().equals(RoomType.SUPER_DELUXE)) {
            room.setRent(1500D * roomRequestDto.getRoomCount());
        }else if(roomRequestDto.getRoomType().equals(RoomType.SUITE)) {
            room.setRent(2500D * roomRequestDto.getRoomCount());
        }

        return room;
    }
    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Booking booking=new Booking();
        Optional<Guests> savedGuests=guestRepo.findByEmail(bookingRequestDto.getCustomerEmail());
        if(savedGuests.isPresent()){
            throw new RuntimeException("USER ALREADY HAVE BOOKING "+bookingRequestDto.getCustomerEmail());
        }
        Guests guests=new Guests();
        guests.setEmail(bookingRequestDto.getCustomerEmail());
        guests.setName(bookingRequestDto.getCustomerName());
        booking.setGuest(guests);
        guestRepo.save(guests);
        booking.setGuest(guests);

        double totalBill = 0.0d;
        String  checkIn=bookingRequestDto.getCheckInDate();
        String checkout=bookingRequestDto.getCheckOutDate();
        long durestionOfStay=checkInAndCheckoutDates(checkIn,checkout);
        System.out.println(durestionOfStay+" DUREATION OF DAYS");
        List<Room>roomlist=new ArrayList<>();
        for(RoomRequestDto room1:bookingRequestDto.getRoomRequestDtos()){
           Room room=from(room1);
           room.setBooking(booking);
          roomlist.add(room);
          totalBill+=room.getRent()*durestionOfStay;
            roomRepo.save(room);
        }

        booking.setRooms(roomlist);
        booking.setCheckInDate(from(bookingRequestDto.getCheckInDate()));
        booking.setCheckOutDate(from(bookingRequestDto.getCheckOutDate()));

        booking.setTotalBill(totalBill);
        bookingRepo.save(booking);

        return from(booking);
    }
    private long checkInAndCheckoutDates(String checkIn,String checkOut){

        // Define formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse strings into LocalDate
        LocalDate checkIndate = LocalDate.parse(checkIn, formatter);
        LocalDate checkOutdate = LocalDate.parse(checkOut, formatter);
        System.out.println(checkIndate+" CHECKOUT DATE ABD "+ checkOutdate);

        // Calculate difference in days
        long daysBetween = ChronoUnit.DAYS.between(checkIndate, checkOutdate);
        System.out.println(daysBetween+" NUMBER OF DAYS ");

        // Ensure minimum stay of 1 day
        long duration = Math.max(1, daysBetween);
        System.out.println(daysBetween+" EXECT  NUMBER OF DAYS ");

        System.out.println("Duration of stay: " + duration + " days");
        return duration;
    }

    private Date from(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(date);
        }catch (ParseException exception) {
            return null;
        }
    }
}

