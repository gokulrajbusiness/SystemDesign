package LLD.Questions.ParkingLotSystem;

public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private final int floorNumber;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType spotType, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorNumber = floorNumber;
        this.isAvailable = true;
    }

    public synchronized boolean isAvailable() { return isAvailable; }

    public synchronized void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isAvailable = false;
    }

    public synchronized void vacateSpot() {
        this.parkedVehicle = null;
        this.isAvailable = true;
    }

    public String getSpotId() { return spotId; }
    public SpotType getSpotType() { return spotType; }
    public int getFloorNumber() { return floorNumber; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }
}
