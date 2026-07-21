package LLD.Questions.ParkingLotSystem;

import java.util.Optional;
import java.util.UUID;

public class EntryGate {
    private final String gateId;
    private final ParkingSpotManager spotManager;

    public EntryGate(String gateId, ParkingSpotManager spotManager) {
        this.gateId = gateId;
        this.spotManager = spotManager;
    }

    public Optional<Ticket> processEntry(Vehicle vehicle) {
        Optional<ParkingSpot> spotOpt = spotManager.assignSpot(vehicle.getVehicleType());
        if (spotOpt.isEmpty()) {
            System.out.println("Entry Gate " + gateId + ": Parking Full for " + vehicle.getVehicleType());
            return Optional.empty();
        }

        ParkingSpot spot = spotOpt.get();
        spot.parkVehicle(vehicle);

        String ticketId = "TKT-" + UUID.randomUUID().toString().substring(0, 8);
        Ticket ticket = new Ticket(ticketId, vehicle, spot);

        System.out.println("Ticket Issued: " + ticketId + " | Spot: " + spot.getSpotId() + " (Floor " + spot.getFloorNumber() + ")");
        return Optional.of(ticket);
    }

    public String getGateId() { return gateId; }
}
