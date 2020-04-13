package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import hu.tarsashazkezelo.tarsashaz.entity.Flat;
import hu.tarsashazkezelo.tarsashaz.entity.Role;
import hu.tarsashazkezelo.tarsashaz.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class OwnerDTO {

    private Long id;
    private String address;
    private String name;
    private String email;
    private String password;
    private Integer phoneNumber;
    private Role role;
    private Integer ownership;

    public OwnerDTO(User user){
        this.id = user.getId();
        this.address = user.getAddress();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole();
        this.ownership = user.getOwnership();
    }

    public User toEntity(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
