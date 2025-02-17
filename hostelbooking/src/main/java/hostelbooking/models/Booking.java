package hostelbooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Guests guest;


    private Double totalBill;
    @OneToMany( mappedBy = "booking",cascade = CascadeType.ALL)
    //Used on the parent entity (It is serialized (included in JSON)).
    @JsonManagedReference
    private List<Room> rooms;

    private Date checkInDate;

    private Date checkOutDate;
}

