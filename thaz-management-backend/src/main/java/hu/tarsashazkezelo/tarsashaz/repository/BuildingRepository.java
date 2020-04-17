package hu.tarsashazkezelo.tarsashaz.repository;

import hu.tarsashazkezelo.tarsashaz.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    @Modifying
    void deleteByIdIn(List<Long> id);
}
