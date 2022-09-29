package ca.quebec.bootcamp.cloudparking.repository;

import ca.quebec.bootcamp.cloudparking.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {
    List<ParkingEntity> findAll();

}
