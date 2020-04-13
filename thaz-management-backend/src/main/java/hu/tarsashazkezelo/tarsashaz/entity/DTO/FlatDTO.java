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

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
        this.setId(model.getId());
        this.setFlatSize(model.getFlatSize());
        this.setFloorNumber(model.getFloorNumber());
        this.setNameOfActualUser(model.getNameOfActualUser());
        this.setBuildingDTO(new BuildingDTO(model.getBuilding()));
        this.setOwnerDTO(new OwnerDTO(model.getUser()));
    }

    public Flat toEntity() {
        Flat flat = new Flat();
        BeanUtils.copyProperties(this,flat);
        flat.setBuilding(this.getBuildingDTO().toEntity());
        flat.setUser(this.getOwnerDTO().toEntity());
        return flat;
    }
}
