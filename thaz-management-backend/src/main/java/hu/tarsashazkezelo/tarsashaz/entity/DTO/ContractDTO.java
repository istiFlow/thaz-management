package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.tarsashazkezelo.tarsashaz.entity.Role;
import hu.tarsashazkezelo.tarsashaz.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContractDTO {

    private Long id;
    private String companyName;
    private Integer taxNumber;
    private String address;
    private String name;
    private String email;
    private Integer phoneNumber;
    private Role role;

    public ContractDTO(User user) {
        this.id = user.getId();
        this.companyName = user.getCompanyName();
        this.taxNumber = user.getTaxNumber();
        this.address = user.getAddress();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole();
    }
    public User toEntity(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
