package hu.tarsashazkezelo.tarsashaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "building_documents")
@AllArgsConstructor
@NoArgsConstructor
public class BuildingDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private LocalDate dayOfUploading;

    @Column
    private LocalDate dayOfModification;

    @Column
    private LocalDate dayOfDeletion;

}
