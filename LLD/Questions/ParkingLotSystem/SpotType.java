package LLD.Questions.ParkingLotSystem;

public enum SpotType {
    SMALL,
    MEDIUM,
    LARGE;

    public boolean canFit(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> true;
            case CAR -> this == MEDIUM || this == LARGE;
            case TRUCK -> this == LARGE;
        };
    }
}
