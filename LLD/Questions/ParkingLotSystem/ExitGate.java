package LLD.Questions.ParkingLotSystem;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
    private final String gateId;
    private final ParkingSpotManager spotManager;
    private final PricingStrategy pricingStrategy;

    public ExitGate(String gateId, ParkingSpotManager spotManager, PricingStrategy pricingStrategy) {
        this.gateId = gateId;
        this.spotManager = spotManager;
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        long durationInHours = Duration.between(ticket.getEntryTime(), exitTime).toHours();

        double totalFee = pricingStrategy.calculateFee(durationInHours, ticket.getVehicle().getVehicleType());
        spotManager.freeSpot(ticket.getAssignedSpot());

        System.out.println("Exit Gate " + gateId + ": Vehicle " + ticket.getVehicle().getLicensePlate() +
                " exited. Fee: $" + totalFee);
        return totalFee;
    }

    public String getGateId() { return gateId; }
}