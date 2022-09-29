package ca.quebec.bootcamp.cloudparking.controller.parking.mapper;

import ca.quebec.bootcamp.cloudparking.controller.parking.dto.ParkingDTO;
import ca.quebec.bootcamp.cloudparking.model.Parking;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ParkingDTOMapper {
    ParkingDTO toDTO(Parking parking);
    Parking toModel(ParkingDTO parkingDTO);

}
