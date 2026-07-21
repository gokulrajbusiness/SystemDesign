package LLD.Questions.ParkingLotSystem;

import java.util.List;

public class Floor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;
    private final DisplayBoard displayBoard;

    public Floor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
        this.displayBoard = new DisplayBoard();
        initDisplayBoard();
    }

    private void initDisplayBoard() {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                displayBoard.updateCount(spot.getSpotType(), 1);
            }
        }
    }

    public void onSpotOccupied(SpotType spotType) {
        displayBoard.updateCount(spotType, -1);
    }

    public void onSpotVacated(SpotType spotType) {
        displayBoard.updateCount(spotType, 1);
    }

    public int getFloorNumber() { return floorNumber; }
    public List<ParkingSpot> getSpots() { return spots; }
    public DisplayBoard getDisplayBoard() { return displayBoard; }
}
