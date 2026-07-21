package LLD.Questions.ParkingLotSystem;

import java.util.EnumMap;
import java.util.Map;

public class DisplayBoard {
    private final Map<SpotType, Integer> freeSpotsCount;

    public DisplayBoard() {
        this.freeSpotsCount = new EnumMap<>(SpotType.class);
        for (SpotType type : SpotType.values()) {
            freeSpotsCount.put(type, 0);
        }
    }

    public synchronized void updateCount(SpotType spotType, int change) {
        int current = freeSpotsCount.getOrDefault(spotType, 0);
        freeSpotsCount.put(spotType, Math.max(0, current + change));
    }

    public void showStatus() {
        System.out.println("=== FLOOR DISPLAY BOARD ===");
        freeSpotsCount.forEach((type, count) ->
                System.out.println(type + " Spots Available: " + count));
        System.out.println("===========================");
    }
}
