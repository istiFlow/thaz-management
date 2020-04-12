package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import hu.tarsashazkezelo.tarsashaz.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContractDTO {

private Role role;
}
