package hu.tarsashazkezelo.tarsashaz.service;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import hu.tarsashazkezelo.tarsashaz.entity.DTO.BuildingDTO;
import hu.tarsashazkezelo.tarsashaz.exception.BuildingNotFoundException;
import hu.tarsashazkezelo.tarsashaz.repository.BuildingRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class BuildingService {
/*
NEEDS VALIDATION
 */
    private BuildingRepository buildingRepository;

    public BuildingDTO createBuilding(BuildingDTO buildingDTO){
        return new BuildingDTO(buildingRepository.save(buildingDTO.toEntity()));
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public Optional<Building> findOneBuilding(Long id){
        return Optional.of(buildingRepository.findById(id))
                .orElseThrow(() -> new BuildingNotFoundException(id));
    }

    public BuildingDTO updateBuildingDetails(Long id, BuildingDTO buildingDTO) {
        buildingDTO.setId(id);
        return new BuildingDTO(buildingRepository.save(buildingDTO.toEntity()));
    }

    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }

    public void deleteMoreBuildings(List<Long> id){
        buildingRepository.deleteByIdIn(id);
    }

}

