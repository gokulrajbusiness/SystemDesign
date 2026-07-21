package LLD.Questions.ParkingLotSystem;

import java.util.List;
import java.util.Optional;

public class ParkingSpotManager {
    private final List<Floor> floors;
    private SpotAllocationStrategy allocationStrategy;

    public ParkingSpotManager(List<Floor> floors, SpotAllocationStrategy allocationStrategy) {
        this.floors = floors;
        this.allocationStrategy = allocationStrategy;
    }

    public synchronized Optional<ParkingSpot> assignSpot(VehicleType vehicleType) {
        Optional<ParkingSpot> spotOpt = allocationStrategy.findSpot(floors, vehicleType);
        if (spotOpt.isPresent()) {
            ParkingSpot spot = spotOpt.get();
            getFloor(spot.getFloorNumber()).onSpotOccupied(spot.getSpotType());
        }
        return spotOpt;
    }

    public synchronized void freeSpot(ParkingSpot spot) {
        spot.vacateSpot();
        getFloor(spot.getFloorNumber()).onSpotVacated(spot.getSpotType());
    }

    public void setAllocationStrategy(SpotAllocationStrategy strategy) {
        this.allocationStrategy = strategy;
    }

    private Floor getFloor(int floorNumber) {
        return floors.stream()
                .filter(f -> f.getFloorNumber() == floorNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Floor"));
    }
}
