package ca.quebec.bootcamp.cloudparking.usecase;

import ca.quebec.bootcamp.cloudparking.exception.ParkingNotFoundException;
import ca.quebec.bootcamp.cloudparking.mapper.ParkingEntityMapper;
import ca.quebec.bootcamp.cloudparking.model.Parking;
import ca.quebec.bootcamp.cloudparking.repository.ParkingRepository;
import ca.quebec.bootcamp.cloudparking.utils.BillCalculatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Component
public class ParkingUseCase {

    private final ParkingRepository parkingRepository;
    private final ParkingEntityMapper parkingEntityMapper;

    @Transactional(readOnly = true)
    public List<Parking> findAllParking() {
        return parkingRepository.findAll()
                .stream()
                .map(parkingEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Parking findById(Long idParking) {
        return parkingEntityMapper.toModel(parkingRepository.findById(idParking)
                .orElseThrow(() ->
                        new ParkingNotFoundException(String.valueOf(idParking))));
    }

    @Transactional
    public Parking createParking(Parking parking) throws Exception {
        var getParking = parkingRepository.findById(parking.getId());
        if (!getParking.isPresent()) {
            return parkingEntityMapper.toModel(parkingRepository.save(parkingEntityMapper.toEntity(parking)));
        }
    return parking;
    }

    @Transactional
    public Parking update(Long idParking, Parking parking) throws Exception {
        if (parkingRepository.findById(idParking).isPresent()) {
            parkingRepository.save(parkingEntityMapper.toEntity(parking));
        } else {
            throw new ParkingNotFoundException(String.valueOf(idParking));
        }
        return parking;
    }

    @Transactional
    public void deleteById(Long idParking) throws Exception {
        if (parkingRepository.findById(idParking).isPresent()) {
            parkingRepository.deleteById(idParking);
        }
        throw new ParkingNotFoundException(String.valueOf(idParking));
    }

    @Transactional
    public Parking checkOut(Parking parking){
        var getParking = findById(parking.getId());
        getParking.setBill(BillCalculatorUtils.getBill(parking));
        return parkingEntityMapper.toModel(parkingRepository.save(parkingEntityMapper.toEntity(getParking)));
       }

}
