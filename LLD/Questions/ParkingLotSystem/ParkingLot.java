package LLD.Questions.ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static volatile ParkingLot instance;

    private final String name;
    private final List<Floor> floors;
    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;
    private ParkingSpotManager spotManager;

    // Private constructor prevents direct instantiation
    private ParkingLot(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
    }

    // Thread-safe Singleton Accessor
    public static ParkingLot getInstance(String name) {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot(name);
                }
            }
        }
        return instance;
    }

    public void initialize(List<Floor> floors, ParkingSpotManager spotManager) {
        this.floors.addAll(floors);
        this.spotManager = spotManager;
    }

    public void addEntryGate(EntryGate gate) { this.entryGates.add(gate); }
    public void addExitGate(ExitGate gate) { this.exitGates.add(gate); }

    public String getName() { return name; }
    public List<Floor> getFloors() { return floors; }
    public ParkingSpotManager getSpotManager() { return spotManager; }
    public List<EntryGate> getEntryGates() { return entryGates; }
    public List<ExitGate> getExitGates() { return exitGates; }
}
