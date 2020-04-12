package hu.tarsashazkezelo.tarsashaz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Kozos_kepviselo_teljes_neve")
    private String fullNameOfRepresentative;

    @Column(name = "cegnev")
    private String companyName;

    @Column
    private Integer taxNumber;

    @Column //közös k. iroda címe
    private String addressOfRepresentative;

    @Column
    private String ownerName;

    @Column
    private String ownerAddress;

    @Column
    private String email;

    @Transient
    private String password;

    @Column
    private Integer phoneNumber;

    @Column
    private Role role;

    @Column // tulajdoni hányad pl 40-60%
    private Integer ownership;

}
