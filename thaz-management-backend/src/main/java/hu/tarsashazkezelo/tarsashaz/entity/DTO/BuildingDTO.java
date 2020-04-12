package hu.tarsashazkezelo.tarsashaz.entity.DTO;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class BuildingDTO {

    private Long id;
    private String address;
    private Integer numberOfFlats;
    private Integer numberOfFloors;
    private Integer numberOfGarage;
    private Integer parkingSpaces;

    public BuildingDTO(Building building) {
        this.id = building.getId();
        this.address = building.getAddress();
        this.numberOfFlats = building.getNumberOfFlats();
        this.numberOfFloors = building.getNumberOfFloors();
        this.numberOfGarage = building.getNumberOfGarage();
        this.parkingSpaces = building.getParkingSpaces();
    }

    public Building toEntity(){
        Building building = new Building();
        BeanUtils.copyProperties(this,building);
        return building;
    }
}
