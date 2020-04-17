package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import hu.tarsashazkezelo.tarsashaz.entity.Flat;
import hu.tarsashazkezelo.tarsashaz.entity.Role;
import hu.tarsashazkezelo.tarsashaz.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class FlatDTO {

    private Long id;
    private Integer flatSize;
    private Integer floorNumber;
    private Role nameOfActualUser;
    private BuildingDTO buildingDTO;
    private OwnerDTO ownerDTO;

    public FlatDTO(Flat model){
        this.id = model.getId();
        this.flatSize = model.getFlatSize();
        this.floorNumber = model.getFloorNumber();
        this.nameOfActualUser = model.getNameOfActualUser();
        this.buildingDTO = new BuildingDTO(model.getBuilding());
        this.ownerDTO = new OwnerDTO(model.getUser());
    }

    public Flat toEntity() {
        Flat flat = new Flat();
        BeanUtils.copyProperties(this,flat);
        flat.setBuilding(this.getBuildingDTO().toEntity());
        flat.setUser(this.getOwnerDTO().toEntity());
        return flat;
    }
}
