package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import hu.tarsashazkezelo.tarsashaz.entity.Role;
import hu.tarsashazkezelo.tarsashaz.entity.User;
import org.springframework.beans.BeanUtils;


public class RepresentativeDTO {
    private Long id;
    private String companyName;
    private Integer taxNumber;
    private String address;
    private String name;
    private String email;
    private String password;
    private Integer phoneNumber;
    private Role role;

    public RepresentativeDTO(User user) {
        this.id = user.getId();
        this.companyName = user.getCompanyName();
        this.taxNumber = user.getTaxNumber();
        this.address = user.getAddress();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.role = user.getRole();
    }

    public User toEntity(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
