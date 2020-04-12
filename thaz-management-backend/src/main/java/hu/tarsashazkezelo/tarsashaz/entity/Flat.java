package hu.tarsashazkezelo.tarsashaz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "flats")
@AllArgsConstructor
@NoArgsConstructor
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer flatSize;

    @Column
    private Integer floorNumber;

    @Enumerated(EnumType.STRING) // tulaj, bérlő, lakó
    private Role nameOfActualUser;

    @ManyToOne
    private Building building;

    public Flat(Long id) {
        this.id = id;
    }

}
