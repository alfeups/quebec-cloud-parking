package ca.quebec.bootcamp.cloudparking.controller;

import ca.quebec.bootcamp.cloudparking.controller.parking.dto.ParkingDTO;
import ca.quebec.bootcamp.cloudparking.controller.parking.mapper.ParkingDTOMapper;
import ca.quebec.bootcamp.cloudparking.usecase.ParkingUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Api(tags = "Parking Controller")
@RequestMapping("/parked")
public class ParkingController {
    private final ParkingUseCase useCase;
    private final ParkingDTOMapper parkingDTOMapper;

    @GetMapping()
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> getParkedCars(){
        return ResponseEntity.ok(
                useCase.findAllParking()
                        .stream()
                        .map(parkingDTOMapper::toDTO)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id_parking}")
    @ApiOperation("Find parking per id")
    public ResponseEntity<ParkingDTO> getParkedCarsById(
            @PathVariable("id_parking") Long idParking) {
        return ResponseEntity.ok(parkingDTOMapper.toDTO(useCase.findById(idParking)));
    }

    @PostMapping()
    @ApiOperation("Create parking registry")
    public ResponseEntity<ParkingDTO> createParking(
            @RequestBody ParkingDTO parkingDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(parkingDTOMapper.toDTO(useCase.createParking(parkingDTOMapper.toModel(parkingDTO))));
    }

    @PutMapping("/{id_parking}")
    @ApiOperation("Update parking by id.")
    public ResponseEntity<ParkingDTO> updateParkingById(
            @RequestBody ParkingDTO parkingDTO,
            @PathVariable("id_parking") Long idParking) throws Exception {
        return ResponseEntity.ok()
                .body(parkingDTOMapper.toDTO(
                        useCase.update(idParking, parkingDTOMapper.toModel(parkingDTO))));
    }

    @DeleteMapping("/{id_parking}")
    @ApiOperation("Delete parking by id.")
    public ResponseEntity deleteParkingById(@PathVariable("id_parking") Long idParking) throws Exception {
        useCase.deleteById(idParking);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id_parking}")
    @ApiOperation("Register exit date of parking.")
    public ResponseEntity<ParkingDTO> exitParking(@RequestBody ParkingDTO parkingDTO){
        return ResponseEntity.ok()
                .body(parkingDTOMapper.toDTO(useCase.checkOut(parkingDTOMapper.toModel(parkingDTO))));
    }

}
