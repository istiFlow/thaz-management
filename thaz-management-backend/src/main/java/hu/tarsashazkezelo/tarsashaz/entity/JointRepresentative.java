package hu.tarsashazkezelo.tarsashaz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Kozos_kepviselo")

public class JointRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cegnev")
    private String companyName;

    @Column
    private Integer taxNumber;

    @Column(name = "Kozos_kepviselo_teljes_neve")
    private String fullNameOfRepresentative;

    @Column
    private String email;

    @Transient
    private String password;

    @Column
    private Integer phoneNumber;

    @Column
    private String address;

}
