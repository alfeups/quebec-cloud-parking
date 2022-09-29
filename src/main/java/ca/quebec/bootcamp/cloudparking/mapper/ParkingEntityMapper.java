package ca.quebec.bootcamp.cloudparking.mapper;

import ca.quebec.bootcamp.cloudparking.entity.ParkingEntity;
import ca.quebec.bootcamp.cloudparking.model.Parking;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ParkingEntityMapper {

    Parking toModel(ParkingEntity parkingEntity);

    ParkingEntity toEntity(Parking parking);

}
