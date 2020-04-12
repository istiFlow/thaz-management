package hu.tarsashazkezelo.tarsashaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "buildings")
@AllArgsConstructor
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String address;

    @Column
    private Integer numberOfFlats;

    @Column
    private Integer numberOfFloors;

    @Column
    private Integer numberOfGarage;

    @Column
    private Integer parkingSpaces;

}
