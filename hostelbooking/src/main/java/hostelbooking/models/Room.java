package hostelbooking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private Double rent;
    @ManyToOne
    @JoinColumn(name = "rooms")
    @JsonBackReference
    //Used on the child entity (It is ignored during serialization to prevent infinite loops.)
    private Booking booking;
}
