package LLD.Questions.ParkingLotSystem;

import java.util.List;
import java.util.Optional;

public interface SpotAllocationStrategy {
    Optional<ParkingSpot> findSpot(List<Floor> floors, VehicleType vehicleType);
}