package hu.tarsashazkezelo.tarsashaz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "buildings")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flat> flats;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BuildingDocument> buildingDocuments;

}
