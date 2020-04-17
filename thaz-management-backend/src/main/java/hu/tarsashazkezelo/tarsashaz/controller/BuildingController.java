package hu.tarsashazkezelo.tarsashaz.controller;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import hu.tarsashazkezelo.tarsashaz.entity.DTO.BuildingDTO;
import hu.tarsashazkezelo.tarsashaz.service.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
@AllArgsConstructor
public class BuildingController {

    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO){
        return new ResponseEntity<>(buildingService.createBuilding(buildingDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Building>> findAll() {
        return new ResponseEntity<>(buildingService.findAll(), HttpStatus.OK);
    }

}
