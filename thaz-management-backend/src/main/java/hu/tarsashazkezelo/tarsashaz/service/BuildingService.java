package hu.tarsashazkezelo.tarsashaz.service;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import hu.tarsashazkezelo.tarsashaz.entity.DTO.BuildingDTO;
import hu.tarsashazkezelo.tarsashaz.repository.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BuildingService {

    private BuildingRepository buildingRepository;

    public BuildingDTO createBuilding(BuildingDTO buildingDTO){
        return new BuildingDTO(buildingRepository.save(buildingDTO.toEntity()));
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }
}

