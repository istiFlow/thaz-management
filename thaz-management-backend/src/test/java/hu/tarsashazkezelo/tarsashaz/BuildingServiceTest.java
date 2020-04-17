package hu.tarsashazkezelo.tarsashaz;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import hu.tarsashazkezelo.tarsashaz.entity.DTO.BuildingDTO;
import hu.tarsashazkezelo.tarsashaz.repository.BuildingRepository;
import hu.tarsashazkezelo.tarsashaz.service.BuildingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTest {
    private static final Building BUILDING_1 = Building.builder().id(1L).address("1111 Bp, Alma utca 1").numberOfFlats(34).numberOfGarage(11).numberOfFloors(5).parkingSpaces(8).build();
    private static final Building BUILDING_2 = Building.builder().id(2L).address("2222 Kecskemét, Eper utca 2").numberOfFlats(14).numberOfGarage(6).numberOfFloors(8).parkingSpaces(20).build();
    private static final Building BUILDING_3 = Building.builder().id(3L).address("3333 Pécs, Paprika utca 3").numberOfFlats(76).numberOfGarage(20).numberOfFloors(10).parkingSpaces(30).build();
    private static final Building BUILDING_4 = Building.builder().id(4L).address("4444 Szeged, Cseresznye utca 4").numberOfFlats(29).numberOfGarage(15).numberOfFloors(8).parkingSpaces(16).build();

    private static final BuildingDTO BUILDING_DTO_1 = BuildingDTO.builder().id(1L).address("1111 Bp, Alma utca 1").numberOfFlats(34).numberOfGarage(11).numberOfFloors(5).parkingSpaces(8).build();
    private static final BuildingDTO BUILDING_DTO_2 = BuildingDTO.builder().id(2L).address("2222 Kecskemét, Eper utca 2").numberOfFlats(14).numberOfGarage(6).numberOfFloors(8).parkingSpaces(20).build();

    @Mock
    private BuildingRepository buildingRepository;

    @InjectMocks
    private BuildingService buildingService;

    @Test
    public void createBuildingTest() {
        when(buildingRepository.save(BUILDING_DTO_1.toEntity())).thenReturn(BUILDING_1);
        when(buildingRepository.save(BUILDING_DTO_2.toEntity())).thenReturn(BUILDING_2);

        BuildingDTO buildingDTO = buildingService.createBuilding(BUILDING_DTO_1);
        BuildingDTO buildingDTO2 = buildingService.createBuilding(BUILDING_DTO_2);

        verify(buildingRepository).save(eq(BUILDING_DTO_1.toEntity()));
        verify(buildingRepository).save(eq(BUILDING_DTO_2.toEntity()));

        assertEquals(BUILDING_DTO_1, buildingDTO);
        assertEquals(BUILDING_DTO_2, buildingDTO2);
    }

    @Test
    public void findAll(){
        List<Building> expectedBuildings = Arrays.asList(BUILDING_1,BUILDING_2,BUILDING_3,BUILDING_4);
        when(buildingRepository.findAll()).thenReturn(expectedBuildings);
        List<Building> actualBuildings = buildingService.findAll();
        assertEquals(actualBuildings,expectedBuildings);
    }

    @Test
    public void findOneTest() {
        when(buildingRepository.findById(3L)).thenReturn(Optional.of(BUILDING_3));
        Optional<Building> building = buildingService.findOneBuilding(3L);
        verify(buildingRepository).findById(3L);
        assertEquals(Optional.of(BUILDING_3), building);
    }

    @Test
    public void updateBuildingTest() {
        Building building = BUILDING_DTO_2.toEntity();
        building.setId(2L);
        when(buildingRepository.save(building)).thenReturn(building);
        buildingService.updateBuildingDetails(2L, BUILDING_DTO_2);

        assertEquals(2L, BUILDING_DTO_2.getId());
        assertEquals("2222 Kecskemét, Eper utca 2", BUILDING_DTO_2.getAddress());
        assertEquals(8, BUILDING_DTO_2.getNumberOfFloors());
        assertEquals(20, BUILDING_DTO_2.getParkingSpaces());
        assertEquals(6, BUILDING_DTO_2.getNumberOfGarage());
    }

    @Test
    public void delete(){
        buildingService.deleteBuilding(4L);
        verify(buildingRepository).deleteById(4L);
    }

    @Test
    public void deleteMore(){
        buildingService.deleteMoreBuildings(List.of(1L,2L,3L));
        verify(buildingRepository).deleteByIdIn(List.of(1L,2L,3L));
    }
}
