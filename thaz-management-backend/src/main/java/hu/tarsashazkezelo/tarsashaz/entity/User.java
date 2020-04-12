package hu.tarsashazkezelo.tarsashaz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Kozos_kepviselo_teljes_neve")
    private String fullNameOfRepresentative;

    @Column(name = "cegnev")
    private String companyName;

    @Column
    private Integer taxNumber;

    @Column
    private String address;

    @Column
    private String name;

    @Column
    private String email;

    @Transient
    @JsonIgnore
    private String password;

    @Column
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column // tulajdoni hányad pl 40-60%
    private Integer ownership;

}
