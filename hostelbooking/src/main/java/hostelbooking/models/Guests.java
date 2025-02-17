package hostelbooking.models;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Setter
@Getter
@Entity
public class Guests {
    @Id
    private String email;

    private String name;
}
