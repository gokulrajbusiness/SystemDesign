package LLD.Questions.ParkingLotSystem;

public interface PricingStrategy {
    double calculateFee(long durationInHours, VehicleType vehicleType);
}

