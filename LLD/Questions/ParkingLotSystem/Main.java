package LLD.Questions.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // 1. Singleton Instance Initialization
        ParkingLot parkingLot = ParkingLot.getInstance("Central Square Parking");

        // 2. Setup Floors and Spots
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot("F1-S1", SpotType.SMALL, 1));
        floor1Spots.add(new ParkingSpot("F1-M1", SpotType.MEDIUM, 1));
        floor1Spots.add(new ParkingSpot("F1-L1", SpotType.LARGE, 1));

        Floor floor1 = new Floor(1, floor1Spots);
        List<Floor> floors = List.of(floor1);

        // 3. Setup Manager, Gates, and Strategies
        ParkingSpotManager spotManager = new ParkingSpotManager(floors, new FirstAvailableStrategy());
        parkingLot.initialize(floors, spotManager);

        EntryGate entryGate1 = new EntryGate("GATE-IN-1", spotManager);
        ExitGate exitGate1 = new ExitGate("GATE-OUT-1", spotManager, new HourlyPricingStrategy());

        parkingLot.addEntryGate(entryGate1);
        parkingLot.addExitGate(exitGate1);

        // Display initial floor board
        floor1.getDisplayBoard().showStatus();

        // 4. Vehicle Enters
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleType.CAR);
        Optional<Ticket> ticketOpt = entryGate1.processEntry(car);

        // Display updated board
        floor1.getDisplayBoard().showStatus();

        // 5. Vehicle Exits
        ticketOpt.ifPresent(exitGate1::processExit);

        // Display board after exit
        floor1.getDisplayBoard().showStatus();
    }
}
