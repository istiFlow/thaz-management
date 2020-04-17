package hu.tarsashazkezelo.tarsashaz.repository;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
