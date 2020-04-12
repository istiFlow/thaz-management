package hu.tarsashazkezelo.tarsashaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    private Building building;

    public Flat(Long id) {
        this.id = id;
    }

}
