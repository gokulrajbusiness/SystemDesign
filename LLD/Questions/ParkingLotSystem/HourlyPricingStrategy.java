package LLD.Questions.ParkingLotSystem;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(long durationInHours, VehicleType vehicleType) {
        long hours = Math.max(1, durationInHours);
        double rate = switch (vehicleType) {
            case BIKE -> 10.0;
            case CAR -> 20.0;
            case TRUCK -> 50.0;
        };
        return hours * rate;
    }
}
