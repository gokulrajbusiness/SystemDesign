package LLD.Questions.ParkingLotSystem;


import java.util.List;
import java.util.Optional;

public class FirstAvailableStrategy implements SpotAllocationStrategy {
    @Override
    public Optional<ParkingSpot> findSpot(List<Floor> floors, VehicleType vehicleType) {
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isAvailable() && spot.getSpotType().canFit(vehicleType)) {
                    return Optional.of(spot);
                }
            }
        }
        return Optional.empty();
    }
}
